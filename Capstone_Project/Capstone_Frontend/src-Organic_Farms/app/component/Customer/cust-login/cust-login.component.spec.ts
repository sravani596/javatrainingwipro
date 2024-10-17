import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustLoginComponent } from './cust-login.component';

describe('CustLoginComponent', () => {
  let component: CustLoginComponent;
  let fixture: ComponentFixture<CustLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustLoginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
