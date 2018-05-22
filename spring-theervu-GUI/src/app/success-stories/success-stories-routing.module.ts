/*
 *
 *  * Copyright 2016-2017 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

/**
 * @author Selvapandy Moorthy
 */

import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SuccessStoriesListComponent} from './success-stories-list/success-stories-list.component';
import {SuccessStoriesAddComponent} from './success-stories-add/success-stories-add.component';
 

const storyRoutes: Routes = [
  {path: 'allsuccessstories', component: SuccessStoriesListComponent},
  {path: 'successstoriesadd', component: SuccessStoriesAddComponent},
];

@NgModule({
  imports: [RouterModule.forChild(storyRoutes)],
  exports: [RouterModule]
})

export class SucessStoriesRoutingModule {
}
