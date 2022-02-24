import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustompipeExampleComponent } from './custompipe-example.component';

describe('CustompipeExampleComponent', () => {
  let component: CustompipeExampleComponent;
  let fixture: ComponentFixture<CustompipeExampleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustompipeExampleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustompipeExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
