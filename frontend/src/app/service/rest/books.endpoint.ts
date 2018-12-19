import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {BookResponse} from "./response/book.response";

@Injectable({
  providedIn: 'root'
})
export class BooksEndpoint {

  private readonly callsBaseUrl: string;

  constructor(private httpClient: HttpClient) {
    this.callsBaseUrl = `${environment.restApi.baseUrl}/books`
  }

  getBooks() {
    return this.httpClient.get<BookResponse[]>(this.callsBaseUrl)
  }

}
