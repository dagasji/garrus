import {User} from './user';
import {Injectable} from '@angular/core';

import {Observable} from 'rxjs';
import {tap, delay} from 'rxjs/operators';
import {of} from 'rxjs/observable/of';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AuthService {
  user: User;

  // store the URL so we can redirect after logging in
  redirectUrl: string;

  private authURL = 'http://localhost:8080/auth';


  constructor(
    private http: HttpClient) {}

  login(user: User): Observable<User> {
    return this.http.post<User>(this.authURL, user, httpOptions);
  }
  
  
  isLoggedIn(){
    return localStorage.getItem('loggedUser')!=null;
  }
 
  logout(): void {
    localStorage.clear();
  }
}