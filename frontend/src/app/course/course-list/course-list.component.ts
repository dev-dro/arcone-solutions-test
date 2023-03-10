import {Component, OnInit} from '@angular/core';
import {CourseService} from '../course.service';
import {Course} from '../course.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  courses: Course[] = [];

  constructor(
    private courseService: CourseService,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.courseService.listCourses().subscribe(courses => {
      this.courses = courses;
      console.log(this.courses);
    });
  }

  create(): void {
    this.router.navigate(['/course/create']);
  }

  edit(course: Course): void {
    this.router.navigate([`/course/${course.id}/edit`]);
  }

  delete(course: Course): void {
    this.courseService.deleteCourse(course.id).subscribe(() => this.ngOnInit());
  }
}
