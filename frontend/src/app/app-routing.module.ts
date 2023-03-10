import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentCreateComponent} from './student/student-create/student-create.component';
import {CourseFormComponent} from './course/course-form/course-form.component';
import {CourseListComponent} from './course/course-list/course-list.component';

const routes: Routes = [
  {path: 'student/create', component: StudentCreateComponent},
  {path: 'course', component: CourseListComponent},
  {path: 'course/create', component: CourseFormComponent},
  {path: 'course/:id/edit', component: CourseFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
