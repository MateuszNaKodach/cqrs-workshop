import {OpinionResponse} from "./opinion.response";

export class BookResponse {
  private id: string;
  private title: string;
  private ratingsCount: number;
  private averageRating: number;
  private lastOpinion: OpinionResponse;
}
