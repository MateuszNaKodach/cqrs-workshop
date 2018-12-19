import {Injectable} from '@angular/core';
import {Subject} from "rxjs";
import {PerformanceStatistics} from "../model/performance-statistics.model";

@Injectable({
  providedIn: 'root'
})
export class PerformanceStatisticsService {

  private performanceStatisticsSubject = new Subject<PerformanceStatistics>();
  private withoutCqrsMilis: number;
  private cqrsMilis: number;

  constructor() {
  }

  updateWithoutCqrsMilis(withoutCqrsMilis) {
    this.withoutCqrsMilis = withoutCqrsMilis;
    this.notifyStatisticsUpdate();
  }

  updateCqrsMilis(cqrsMilis) {
    this.cqrsMilis = cqrsMilis;
    this.notifyStatisticsUpdate();
  }

  private notifyStatisticsUpdate() {
    if (this.withoutCqrsMilis && this.cqrsMilis) {
      this.performanceStatisticsSubject.next(
        new PerformanceStatistics(this.withoutCqrsMilis, this.cqrsMilis)
      )
    }
  }

  observeStatistics() {
    return this.performanceStatisticsSubject.asObservable();
  }

}
