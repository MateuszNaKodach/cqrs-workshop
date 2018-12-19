import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookCqrsExplorerComponent } from './book-cqrs-explorer.component';

describe('BookCqrsExplorerComponent', () => {
  let component: BookCqrsExplorerComponent;
  let fixture: ComponentFixture<BookCqrsExplorerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookCqrsExplorerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookCqrsExplorerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
