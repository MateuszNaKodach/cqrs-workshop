import {Component, Input, OnInit} from '@angular/core';
import {BookResponse} from "../../../service/rest/response/book.response";

@Component({
  selector: 'app-book-item',
  templateUrl: './book-item.component.html',
  styleUrls: ['./book-item.component.scss']
})
export class BookItemComponent implements OnInit {

  @Input() book: BookResponse;

  constructor() {
  }

  ngOnInit() {
  }

}
