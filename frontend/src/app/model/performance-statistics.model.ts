export class PerformanceStatistics {
  withoutCqrsMilis: number;
  cqrsMilis: number;

  constructor(withoutCqrsMilis: number, cqrsMilis: number) {
    this.withoutCqrsMilis = withoutCqrsMilis;
    this.cqrsMilis = cqrsMilis;
  }
}
