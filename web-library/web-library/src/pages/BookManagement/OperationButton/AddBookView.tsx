import React, { useEffect, useState } from 'react';
import { Button, Form, message, Modal } from 'antd';
import { BookEntity } from '@/entity/bookEntity';
import BookForm from '@/components/BookList/BookForm';
import { connect } from 'dva';
import { ConnectProps } from 'umi';
interface AddBookViewProps extends Partial<ConnectProps> {}

const AddBookView: React.FC<AddBookViewProps> = (props: AddBookViewProps) => {
  const [showModal, setShowModal] = useState<boolean>(false);
  const [form] = Form.useForm();

  const onAddButtonClick = () => {
    setShowModal(true);
  };
  const onOk = async () => {
    let newBook = new BookEntity();
    newBook.bookName = form.getFieldValue('bookName');
    newBook.subTitle = form.getFieldValue('subTitle');
    newBook.categoryId = form.getFieldValue('categoryId');
    newBook.author = form.getFieldValue('author');
    newBook.description = form.getFieldValue('description');
    props
      .dispatch?.({
        type: 'book/addBook',
        payload: newBook,
      })
      .then((value: boolean) => {
        if (value == true) {
          form.resetFields();
        } else {
          message.warning('添加图书失败!');
        }
      });
    setShowModal(false);
  };
  const onCancel = () => {
    setShowModal(false);
  };
  return (
    <>
      <Button onClick={onAddButtonClick}>添加</Button>
      <Modal title={'添加图书'} visible={showModal} onOk={onOk} onCancel={onCancel}>
        <Form form={form}>
          <BookForm />
        </Form>
      </Modal>
    </>
  );
};

export default connect(() => ({}))(AddBookView);
