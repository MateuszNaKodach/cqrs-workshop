import {Component, OnInit} from '@angular/core';
import {PerformanceStatisticsService} from "../../service/performance-statistics.service";
import {PerformanceStatistics} from "../../model/performance-statistics.model";
import {tap} from "rxjs/operators";
import {Observable, Subscription} from "rxjs";

@Component({
  selector: 'app-performance-stats',
  templateUrl: './performance-stats.component.html',
  styleUrls: ['./performance-stats.component.scss']
})
export class PerformanceStatsComponent implements OnInit {

  performanceStatistics$: Observable<PerformanceStatistics>;

  constructor(private performanceService: PerformanceStatisticsService) {
  }

  ngOnInit() {
    this.performanceStatistics$ = this.performanceService.observeStatistics()
  }

}
