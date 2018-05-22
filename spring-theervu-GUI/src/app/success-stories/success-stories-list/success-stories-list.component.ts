import {Component, OnInit} from '@angular/core';
import {SuccessStoriesService} from '../success-stories.service';
import {successstories} from '../successstories';
import 'rxjs/Rx';
import {Router} from '@angular/router';

@Component({
 selector: 'app-success-stories-list',
  templateUrl: './success-stories-list.component.html',
  styleUrls: ['./success-stories-list.component.css']
})
export class SuccessStoriesListComponent implements OnInit {
  errorMessage: string;
  successstories: successstories[];

  constructor(private router: Router, private successService: SuccessStoriesService) {
  }

  ngOnInit() {
    this.successService.getOwners().subscribe(
      successstories => this.successstories = successstories,
      error => this.errorMessage = <any> error);
      alert(this.successstories);
  }
/*
  onSelect(owner: Owner) {
    this.router.navigate(['/owners', owner.id]);
  }
*/
  addSuccessStory() {
    this.router.navigate(['/successstoriesadd/']);
  }
 
}
