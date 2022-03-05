import React, { useEffect, useState } from 'react';
import { Button, Form, Input, message, Modal, Select } from 'antd';
import { updateBook, getBook } from '@/services/library/bookService';
import { BookEntity } from '@/entity/bookEntity';
import BookForm from '@/components/BookList/BookForm';
import { connect } from 'dva';
import { ConnectProps } from 'umi';
interface UpdateBookViewProps extends Partial<ConnectProps> {
  bookId: number;
}

const UpdateBookView: React.FC<UpdateBookViewProps> = (props: UpdateBookViewProps) => {
  const [showModal, setShowModal] = useState<boolean>(false);
  const [oldBook, setOldBook] = useState<BookEntity>();
  const [form] = Form.useForm();

  useEffect(() => {
    if (!showModal) {
      return;
    }
    getOldBook(props.bookId);
  }, [showModal]);

  const getOldBook = async (bookId: number) => {
    let oldBook = await getBook(bookId);
    form.setFieldsValue({
      bookName: oldBook.bookName,
      subTitle: oldBook.subTitle,
      categoryId: oldBook.categoryId,
      author: oldBook.author,
      description: oldBook.description,
    });
    setOldBook(oldBook);
  };

  const onUpdateButtonClick = () => {
    setShowModal(true);
  };
  const onOk = async () => {
    let newBook = new BookEntity();
    newBook.bookId = oldBook?.bookId;
    newBook.bookName = form.getFieldValue('bookName');
    newBook.subTitle = form.getFieldValue('subTitle');
    newBook.categoryId = form.getFieldValue('categoryId');
    newBook.author = form.getFieldValue('author');
    newBook.description = form.getFieldValue('description');
    if (
      oldBook?.bookName !== newBook.bookName ||
      oldBook?.subTitle !== newBook.subTitle ||
      oldBook?.author !== newBook.author ||
      oldBook?.categoryId !== newBook.categoryId ||
      oldBook?.description !== newBook.description
    ) {
      props
        .dispatch?.({
          type: 'book/updateBook',
          payload: newBook,
        })
        .then((value: boolean) => {
          if (value == false) {
            message.warning('编辑图书失败!');
          }
        });
    }
    setShowModal(false);
  };
  const onCancel = () => {
    setShowModal(false);
  };
  return (
    <>
      <Button onClick={onUpdateButtonClick}>修改</Button>
      <Modal title={'修改图书'} visible={showModal} onOk={onOk} onCancel={onCancel}>
        <Form form={form}>
          <BookForm />
        </Form>
      </Modal>
    </>
  );
};
export default connect(() => ({}))(UpdateBookView);
