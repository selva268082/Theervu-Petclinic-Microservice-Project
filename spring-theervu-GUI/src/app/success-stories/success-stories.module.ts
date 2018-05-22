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
import {SuccessStoriesService} from './success-stories.service';
import {SuccessStoriesListComponent} from './success-stories-list/success-stories-list.component';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {SucessStoriesRoutingModule} from './success-stories-routing.module';
import { SuccessStoriesAddComponent } from './success-stories-add/success-stories-add.component';
 

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SucessStoriesRoutingModule
     
  ],
  declarations: [
                 SuccessStoriesListComponent,
                 SuccessStoriesAddComponent
    
  ],
  providers: [SuccessStoriesService]

})

export class SucessStoriesModule {
}
