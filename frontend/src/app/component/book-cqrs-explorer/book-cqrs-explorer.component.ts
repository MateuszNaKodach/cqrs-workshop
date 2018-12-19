import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BookResponse} from "../../service/rest/response/book.response";
import {BooksCqrsEndpoint} from "../../service/rest/books.cqrs-endpoint";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-book-cqrs-explorer',
  templateUrl: './book-cqrs-explorer.component.html',
  styleUrls: ['./book-cqrs-explorer.component.scss']
})
export class BookCqrsExplorerComponent implements OnInit {

  books$: Observable<BookResponse[]>;
  lastRequestMillis: number;

  constructor(private booksEndpoint: BooksCqrsEndpoint) {
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
