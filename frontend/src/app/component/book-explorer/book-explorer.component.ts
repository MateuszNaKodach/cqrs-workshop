import {Component, OnInit} from '@angular/core';
import {BooksEndpoint} from "../../service/rest/books.endpoint";
import {BookResponse} from "../../service/rest/response/book.response";
import {Observable} from "rxjs";
import {BooksCqrsEndpoint} from "../../service/rest/books.cqrs-endpoint";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-book-explorer',
  templateUrl: './book-explorer.component.html',
  styleUrls: ['./book-explorer.component.scss']
})
export class BookExplorerComponent implements OnInit {

  books$: Observable<BookResponse[]>;
  lastRequestMillis: number;

  constructor(private booksEndpoint: BooksEndpoint) {
  }

  ngOnInit() {
    let t0 = performance.now();
    this.books$ = this.booksEndpoint.getBooks()
      .pipe(
        tap(_ => {
          this.lastRequestMillis = performance.now() - t0
        })
      );
  }

}
