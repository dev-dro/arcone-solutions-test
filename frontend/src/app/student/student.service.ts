import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Student} from './student.model';
import {Observable, throwError} from 'rxjs';
import {AlertService} from '../alert/alert.service';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  studentUrl = '/api/students';

  constructor(
    private http: HttpClient,
    private alertService: AlertService
  ) {
  }

  createStudent(student: Student): Observable<any> {
    return this.http.post(this.studentUrl, student)
    .pipe(
      catchError(err => this.handleError(err))
    );
  }

  private handleError(error: HttpErrorResponse): Observable<any> {
    if (error.status === 400) {
      error.error.messages.forEach((message: string) => this.alertService.warning(message));
    } else {
      this.alertService.error(error.message);
    }
    return throwError(error);
  }
}
