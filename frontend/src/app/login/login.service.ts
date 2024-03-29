import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginApiUrl = '/api/login';

  constructor(private http: HttpClient) {
  }

  login(user: any): Observable<any> {
    return this.http.post(this.loginApiUrl, user);
  }
}
