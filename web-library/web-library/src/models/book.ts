import { BookEntity } from '@/entity/bookEntity';
import { addBook, deleteBook, getBooks, updateBook } from '@/services/library/bookService';
import { BookReplyDto, BookPageDto } from '@/services/library/dto/bookDto';
import { Effect, Reducer } from 'umi';

export interface BookModelState {
  books?: BookEntity[];
  total?: number;
  page?: number;
}
export interface BookModelType {
  namespace: 'book';
  state: BookModelState;
  effects: {
    fetchBooks: Effect;
    addBook: Effect;
    updateBook: Effect;
    deleteBook: Effect;
  };
  reducers: {
    save: Reducer<BookModelState>;
    savePage: Reducer<BookModelState>;
  };
}
const BookModel: BookModelType = {
  namespace: 'book',
  state: { books: [], total: 1, page: 1 },
  effects: {
    *fetchBooks({ payload }, { call, put }) {
      let getBooksReply: BookPageDto = yield call(getBooks, payload);
      yield put({
        type: 'save',
        payload: {
          books: getBooksReply.records,
          total: getBooksReply.total,
        },
      });
    },
    *addBook({ payload }, { call, put, select }) {
      let addBookReply: BookReplyDto = yield call(addBook, payload);
      let pageBooks: BookEntity[] = yield select((state: any) => state.book.books);
      //添加图书在本页上，修改model
      if (pageBooks.length < 10)
        yield put({
          type: 'save',
          payload: {
            books: [...pageBooks, payload],
          },
        });
      return addBookReply.result;
    },
    *updateBook({ payload }, { call, put, select }) {
      let updateBookReply: BookReplyDto = yield call(updateBook, payload);
      let pageBooks: BookEntity[] = yield select((state: any) => state.book.books);
      if (updateBookReply.result == true) {
        let updateIndex = pageBooks.findIndex((b) => b.bookId == updateBookReply.value?.bookId);
        let newPageBooks = [...pageBooks];
        newPageBooks[updateIndex] = updateBookReply.value!;
        yield put({
          type: 'save',
          payload: {
            books: newPageBooks,
          },
        });
      }
      return updateBookReply.result;
    },
    *deleteBook({ payload }, { call, put, select }) {
      let result: boolean = yield call(deleteBook, payload);
      return result;
    },
  },
  reducers: {
    save(state, action) {
      return {
        books: action.payload.books ? action.payload.books : state?.books,
        total: action.payload.total ? action.payload.total : state?.total,
        page: action.payload.page ? action.payload.page : state?.page,
      };
    },
    savePage(state, action) {
      return {
        ...state,
        page: action.payload.page,
      };
    },
  },
};
export default BookModel;
