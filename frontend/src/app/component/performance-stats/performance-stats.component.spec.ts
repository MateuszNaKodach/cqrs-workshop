import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerformanceStatsComponent } from './performance-stats.component';

describe('PerformanceStatsComponent', () => {
  let component: PerformanceStatsComponent;
  let fixture: ComponentFixture<PerformanceStatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerformanceStatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerformanceStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
