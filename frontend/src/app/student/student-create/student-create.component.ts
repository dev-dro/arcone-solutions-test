import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../student.service';
import {Student} from '../student.model';
import {AlertService} from '../../alert/alert.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {

  genders: Array<string> = ['Male', 'Female', 'Other'];
  studentForm: FormGroup = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    dateOfBirth: ['', Validators.required],
    gender: ['', Validators.required],
    email: ['', Validators.required],
    phoneNumber: ['', Validators.required],
    address: ['', Validators.required]
  });

  constructor(
    private formBuilder: FormBuilder,
    private studentService: StudentService,
    private alertService: AlertService,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.studentForm.valid) {
      this.alertService.clearAlerts();
      const student: Student = this.studentForm.value;
      this.studentService.createStudent(student).subscribe(() => {
        this.alertService.success('User created, enter your credentials');
        this.router.navigate(['/login']);
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/login']);
  }
}
