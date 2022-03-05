import React, { useEffect, useState } from 'react';
import { Button, message } from 'antd';
import { connect } from 'dva';
import { BookModelState } from '@/models/book';
import { ConnectProps } from 'umi';
interface DeleteBookViewProps extends Partial<ConnectProps> {
  bookId: number;
  page?: number;
}

const DeleteBookView: React.FC<DeleteBookViewProps> = (props: DeleteBookViewProps) => {
  const onDeleteButtonClick = async () => {
    props
      .dispatch?.({
        type: 'book/deleteBook',
        payload: props.bookId,
      })
      .then((value: boolean) => {
        if (value == true) {
          props.dispatch?.({
            type: 'book/fetchBooks',
            payload: props.page,
          });
        } else {
          message.warning('删除图书失败');
        }
      });
  };
  return (
    <>
      <Button onClick={onDeleteButtonClick}>删除</Button>
    </>
  );
};
export default connect(({ book }: { book: BookModelState }) => ({
  page: book.page,
}))(DeleteBookView);
