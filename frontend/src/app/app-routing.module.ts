import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {BookExplorerComponent} from "./component/book-explorer/book-explorer.component";
import {BookCqrsExplorerComponent} from "./component/book-cqrs-explorer/book-cqrs-explorer.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'without-cqrs',
    pathMatch: 'full'
  },
  {
    path: 'without-cqrs',
    component: BookExplorerComponent,
  },
  {
    path: 'cqrs',
    component: BookCqrsExplorerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
