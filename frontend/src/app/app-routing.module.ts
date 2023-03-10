import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentCreateComponent} from './student/student-create/student-create.component';

const routes: Routes = [
  {path: 'student/create', component: StudentCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
