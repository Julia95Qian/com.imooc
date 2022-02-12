import { request } from "umi";

/**获取图书 */
export async function getBooks(page: number):Promise<BookPageDto> {
    return request('/apiLibrary/books', {
        method: 'GET',
        params: {
            page: page,
        }
    }).then((value) => {
        return value.data;
    });          
}