import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessStoriesAddComponent } from './success-stories-add.component';

describe('SuccessStoriesAddComponent', () => {
  let component: SuccessStoriesAddComponent;
  let fixture: ComponentFixture<SuccessStoriesAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuccessStoriesAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuccessStoriesAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
