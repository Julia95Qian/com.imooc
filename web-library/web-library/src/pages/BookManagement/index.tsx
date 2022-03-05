import SearchInputs from '@/components/BookList/SearchInputs';
import { BookEntity } from '@/entity/bookEntity';
import { BookModelState } from '@/models/book';
import { SearchOutlined } from '@ant-design/icons';
import { PageContainer } from '@ant-design/pro-layout';
import { Table, Row, Col, Form, Card, Space } from 'antd';
import React, { useEffect, useState } from 'react';
import { connect, ConnectProps } from 'umi';
import AddBookView from './OperationButton/AddBookView';
import DeleteBookView from './OperationButton/DeleteBookView';
import UpdateBookView from './OperationButton/UpdateBookView';

export const categoryType = ['前端', '后端', '测试', '产品'];
function convertCategoryType(dataIndex: number) {
  if (dataIndex <= categoryType.length) {
    return categoryType[dataIndex - 1];
  } else {
    return '';
  }
}
function operationButton(dataIndex: number) {
  return (
    <>
      <UpdateBookView bookId={dataIndex} />
      <DeleteBookView bookId={dataIndex} />
    </>
  );
}
interface BookManagementProps extends ConnectProps {
  books?: BookEntity[];
  total?: number;
  page?: number;
}
const BookManagement: React.FC<BookManagementProps> = (props: BookManagementProps) => {
  const { page } = props;
  const [searchForm] = Form.useForm();

  useEffect(() => {
    setPage(1);
    fetchBooks(1);
  }, []);
  useEffect(() => {
    searchForm.setFieldsValue({
      sBookName: '',
      sSubTitle: '',
      sCategoryId: '',
      sAuthor: '',
    });
  }, []);
  const fetchBooks = (page: number) => {
    props.dispatch?.({
      type: 'book/fetchBooks',
      payload: {
        page: page,
        bookNameWord: searchForm.getFieldValue('sBookName'),
        categoryId: searchForm.getFieldValue('sCategoryId'),
        subNameWord: searchForm.getFieldValue('sSubTitle'),
        authorNameWord: searchForm.getFieldValue('sAuthor'),
      },
    });
  };
  const setPage = (page: number) => {
    props.dispatch?.({
      type: 'book/savePage',
      payload: {
        page: page,
      },
    });
  };
  const onSearchClick = () => {
    setPage(1);
    fetchBooks(1);
  };
  const onPageChange = (page: any) => {
    setPage(page);
    fetchBooks(page);
  };

  const columns = [
    {
      title: '书名',
      dataIndex: 'bookName',
      key: 'bookName',
    },
    {
      title: '类别',
      dataIndex: 'categoryId',
      key: 'categoryId',
      sorter: (a: BookEntity, b: BookEntity) => a.categoryId! - b.categoryId!,
      sortDirection: ['descend', 'ascend'],
      render: convertCategoryType,
    },
    {
      title: '子标题',
      dataIndex: 'subTitle',
      key: 'subTitle',
    },
    {
      title: '作者',
      dataIndex: 'author',
      key: 'author',
    },
    {
      title: '操作',
      dataIndex: 'bookId',
      render: operationButton,
    },
  ];

  return (
    <PageContainer>
      <Space direction="vertical" size={8} style={{ display: 'flex' }}>
        <Card style={{ width: '100%' }}>
          <Row>
            <Col>
              <AddBookView />
            </Col>
          </Row>
          <Row>
            <Col span={22}>
              <Form form={searchForm} layout="inline">
                <SearchInputs />
              </Form>
            </Col>
            <Col span={2}>
              <SearchOutlined onClick={onSearchClick} />
            </Col>
          </Row>
        </Card>
        <Row>
          <Col span={24}>
            <Table
              style={{ width: '100%' }}
              columns={columns}
              pagination={{
                current: page,
                onChange: onPageChange,
                position: ['bottomRight'],
                total: props.total,
              }}
              dataSource={props.books}
            />
          </Col>
        </Row>
      </Space>
    </PageContainer>
  );
};

export default connect(({ book }: { book: BookModelState }) => ({
  books: book.books,
  total: book.total,
  page: book.page,
}))(BookManagement);
