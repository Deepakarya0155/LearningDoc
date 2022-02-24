import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BindingexampleComponent } from './bindingexample.component';

describe('BindingexampleComponent', () => {
  let component: BindingexampleComponent;
  let fixture: ComponentFixture<BindingexampleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BindingexampleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BindingexampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
