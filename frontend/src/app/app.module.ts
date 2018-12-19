import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './component/book-list/book-list.component';
import { BookItemComponent } from './component/book-list/book-item/book-item.component';
import { BookCreatorComponent } from './component/book-creator/book-creator.component';
import {HttpClientModule} from "@angular/common/http";
import { BookExplorerComponent } from './component/book-explorer/book-explorer.component';
import { BookCqrsExplorerComponent } from './component/book-cqrs-explorer/book-cqrs-explorer.component';
import { LoaderComponent } from './component/loader/loader.component';
import { PerformanceStatsComponent } from './component/performance-stats/performance-stats.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookItemComponent,
    BookCreatorComponent,
    BookExplorerComponent,
    BookCqrsExplorerComponent,
    LoaderComponent,
    PerformanceStatsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
