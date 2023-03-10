import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AlertService} from '../alert/alert.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LoginService} from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
  });

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private loginService: LoginService,
    private alertService: AlertService,
  ) {
  }

  ngOnInit(): void {
    sessionStorage.setItem('token', '');
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const user: { username: string, password: string } = this.loginForm.value;
      this.loginService.login(user).subscribe(isValid => {
        if (isValid) {
          sessionStorage.setItem('token', btoa(user.username + ':' + user.password));
          this.router.navigate(['/']);
        } else {
          this.alertService.warning('Authentication failed.');
        }
      });
    }
  }

  registerNewStudent(): void {
    this.router.navigate(['/student/create']);
  }
}
