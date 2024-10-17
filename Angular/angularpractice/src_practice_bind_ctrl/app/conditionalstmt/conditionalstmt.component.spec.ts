import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConditionalstmtComponent } from './conditionalstmt.component';

describe('ConditionalstmtComponent', () => {
  let component: ConditionalstmtComponent;
  let fixture: ComponentFixture<ConditionalstmtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConditionalstmtComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConditionalstmtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
