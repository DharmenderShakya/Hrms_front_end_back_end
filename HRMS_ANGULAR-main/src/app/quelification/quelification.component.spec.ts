import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuelificationComponent } from './quelification.component';

describe('QuelificationComponent', () => {
  let component: QuelificationComponent;
  let fixture: ComponentFixture<QuelificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuelificationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuelificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
