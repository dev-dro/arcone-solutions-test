import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {StudentCreateComponent} from './student/student-create/student-create.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AlertComponent} from './alert/alert.component';
import {CourseFormComponent} from './course/course-form/course-form.component';
import {CourseListComponent} from './course/course-list/course-list.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentCreateComponent,
    AlertComponent,
    CourseFormComponent,
    CourseListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
