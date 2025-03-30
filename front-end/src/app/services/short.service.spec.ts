import { TestBed, inject } from '@angular/core/testing';

import { ShortService } from './short.service';

describe('AccountService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShortService]
    });
  });

  it('should be created', inject([ShortService], (service: ShortService) => {
    expect(service).toBeTruthy();
  }));
});
