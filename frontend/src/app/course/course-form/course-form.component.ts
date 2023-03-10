import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Course} from '../course.model';
import {CourseService} from '../course.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-course-create',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent implements OnInit {

  course: Course = new Course();

  courseForm: FormGroup = this.formBuilder.group({
    name: ['', Validators.required],
    duration: [0, Validators.required],
    startDate: ['', Validators.required],
    endDate: [{value: '', disabled: true}]
  });

  constructor(
    private formBuilder: FormBuilder,
    private courseService: CourseService,
    private router: Router,
    private route: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params.id) {
        this.courseService.findCourse(params.id).subscribe(course => {
          this.course = course;
          this.courseForm.controls.name.setValue(this.course.name);
          this.courseForm.controls.duration.setValue(this.course.duration);
          this.courseForm.controls.startDate.setValue(this.course.startDate);
          this.courseForm.controls.endDate.setValue(this.course.endDate);
        });
      }
    });
  }

  onSubmit(): void {
    if (this.courseForm.valid) {
      const course: Course = this.courseForm.value;
      if (this.course.id) {
        this.courseService.updateCourse(this.course.id, course).subscribe(() => this.router.navigate(['/course']));
      } else {
        this.courseService.createCourse(course).subscribe(() => this.router.navigate(['/course']));
      }
    }
  }

  cancel(): void {
    this.router.navigate(['/course']);
  }
}
