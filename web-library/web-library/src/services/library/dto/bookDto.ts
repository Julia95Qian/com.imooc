import { BookEntity } from '@/entity/bookEntity';

export class BookPageDto {
  public pages?: number;
  public current?: number;
  public records?: any;
  public size?: number;
  public total?: number;

  // public BookPageDto(dto: BookPageDto){
  //     this.pages = dto.pages;
  //     this.current = dto.current;
  //     this.records = dto.records;
  //     this.size = dto.size;
  //     this.total = dto.total;
  // }
}
export class BookReplyDto {
  public result?: boolean;
  public value?: BookEntity;
}
export class BooksRequestDto {
  public page?: number;
  public limit?: number;
  public bookNameWord?: string;
  public categoryId?: number;
  public subNameWord?: string;
  public authorNameWord?: string;
}
