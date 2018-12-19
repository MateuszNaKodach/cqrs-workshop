import {OpinionResponse} from "./opinion.response";

export class BookResponse {
  id: string;
  title: string;
  author: string;
  genre: string;
  ratingsCount: number;
  averageRating: number;
  lastOpinion: OpinionResponse;
}
