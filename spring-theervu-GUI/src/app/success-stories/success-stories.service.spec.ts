import { TestBed, inject } from '@angular/core/testing';

import { SuccessStoriesService } from './success-stories.service';

describe('SuccessStoriesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SuccessStoriesService]
    });
  });

  it('should be created', inject([SuccessStoriesService], (service: SuccessStoriesService) => {
    expect(service).toBeTruthy();
  }));
});
