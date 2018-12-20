import {Component, Input, OnInit} from '@angular/core';
import {BookResponse} from "../../service/rest/response/book.response";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  @Input() books: BookResponse[];

  constructor() {
  }

  ngOnInit() {
  }

}
