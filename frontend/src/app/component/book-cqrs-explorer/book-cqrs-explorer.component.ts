import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {BookResponse} from "../../service/rest/response/book.response";
import {BooksCqrsEndpoint} from "../../service/rest/books.cqrs-endpoint";
import {filter, tap} from "rxjs/operators";
import {PerformanceStatisticsService} from "../../service/performance-statistics.service";
import {EventSourcePolyfill} from "ng-event-source";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-book-cqrs-explorer',
  templateUrl: './book-cqrs-explorer.component.html',
  styleUrls: ['./book-cqrs-explorer.component.scss']
})
export class BookCqrsExplorerComponent implements OnInit, OnDestroy {

  books$: Observable<BookResponse[]>;
  lastRequestMillis: number;
  eventSource: EventSourcePolyfill;
  isObserving: boolean = false;

  constructor(private booksEndpoint: BooksCqrsEndpoint, private performanceService: PerformanceStatisticsService) {
  }

  ngOnInit() {
    this.updateBooks();
  }

  private updateBooks() {
    let t0 = performance.now();
    this.books$ = this.booksEndpoint.getBooks()
      .pipe(
        tap(_ => {
          this.lastRequestMillis = performance.now() - t0;
          this.performanceService.updateCqrsMilis(this.lastRequestMillis);
        })
      );
  }

  onClickNewFakeBook() {
    this.booksEndpoint.addNewBook()
      .pipe(
        filter(_ => !this.eventSource),
        tap(_ => this.updateBooks())
      ).subscribe();
  }

  toggleObserveEvents() {
    if (this.eventSource) {
      this.stopObserveEvents();
    } else {
      this.startObserveEvents();
    }
  }

  private startObserveEvents() {
    this.eventSource = new EventSourcePolyfill(
      `${environment.restApi.baseUrl}/cqrs/books/event-stream`, {}
    );
    this.eventSource.onmessage = (event => {
      if (JSON.parse(event.data).title) {
        this.updateBooks();
      }
    });
  }

  private stopObserveEvents() {
    if (this.eventSource) {
      this.eventSource.close();
      this.eventSource = null;
    }
  }

  ngOnDestroy(): void {
    this.stopObserveEvents();
  }

}
