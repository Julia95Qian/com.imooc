import { BookEntity } from '@/entity/bookEntity';
import { request } from 'umi';
import { BookPageDto, BooksRequestDto } from './dto/bookDto';

/**获取图书 */
export async function getBooks(requestDto: BooksRequestDto): Promise<BookPageDto> {
  return request('/apiLibrary/books', {
    method: 'GET',
    params: requestDto,
  }).then((value) => {
    return value.data;
  });
}
/**添加图书 */
export async function addBook(book: BookEntity): Promise<{ result: boolean; value: BookEntity }> {
  return request('/apiLibrary/addBook', {
    method: 'POST',
    params: book,
  }).then((value) => {
    return { result: value.success, value: value.data };
  });
}
/**获取单本图书 */
export async function getBook(bookId: number): Promise<BookEntity> {
  return request('/apiLibrary/book/' + bookId, {
    method: 'GET',
  }).then((value) => {
    return value.data;
  });
}
/**修改图书 */
export async function updateBook(
  bookEntity: BookEntity,
): Promise<{ result: boolean; value: BookEntity }> {
  return request('/apiLibrary/update', {
    method: 'POST',
    params: bookEntity,
  }).then((value) => {
    return { result: value.success, value: value.data };
  });
}
/**删除图书 */
export async function deleteBook(bookId: number): Promise<boolean> {
  return request('/apiLibrary/delete/' + bookId, {
    method: 'POST',
  }).then((value) => {
    return value.success;
  });
}
