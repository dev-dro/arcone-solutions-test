import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../student.service';
import {Student} from '../student.model';
import {AlertService} from '../../alert/alert.service';

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
  ) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.studentForm.valid) {
      this.alertService.clearAlerts();
      const student: Student = this.studentForm.value;
      this.studentService.createStudent(student).subscribe(result => console.log(result));
    }
  }
}
