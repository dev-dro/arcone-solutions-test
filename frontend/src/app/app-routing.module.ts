import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentCreateComponent} from './student/student-create/student-create.component';
import {CourseFormComponent} from './course/course-form/course-form.component';
import {CourseListComponent} from './course/course-list/course-list.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'students/create', component: StudentCreateComponent},
  {path: 'courses', component: CourseListComponent},
  {path: 'courses/create', component: CourseFormComponent},
  {path: 'courses/:id/edit', component: CourseFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
