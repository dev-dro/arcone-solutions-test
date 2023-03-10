import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Student} from './student.model';
import {Observable} from 'rxjs';
import {AlertService} from '../alert/alert.service';
import {catchError} from 'rxjs/operators';
import {AppService} from '../app.service';

@Injectable({
  providedIn: 'root'
})
export class StudentService extends AppService {

  studentUrl = '/api/students';

  constructor(
    private http: HttpClient,
    protected alertService: AlertService
  ) {
    super(alertService);
  }

  createStudent(student: Student): Observable<any> {
    return this.http.post(this.studentUrl, student)
    .pipe(
      catchError(err => this.handleError(err))
    );
  }
}
