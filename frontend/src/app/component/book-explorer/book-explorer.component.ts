import {Component, OnInit} from '@angular/core';
import {BooksEndpoint} from "../../service/rest/books.endpoint";
import {BookResponse} from "../../service/rest/response/book.response";
import {Observable} from "rxjs";

@Component({
  selector: 'app-book-explorer',
  templateUrl: './book-explorer.component.html',
  styleUrls: ['./book-explorer.component.scss']
})
export class BookExplorerComponent implements OnInit {

  books$: Observable<BookResponse[]>;

  constructor(private booksEndpoint: BooksEndpoint) {
  }

  ngOnInit() {
    this.books$ = this.booksEndpoint.getBooks();
  }

}
