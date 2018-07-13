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
export class UserService {
  user: User;

  // store the URL so we can redirect after logging in
  redirectUrl: string;

  private authURL = 'http://localhost:8080/user';


  constructor(
    private http: HttpClient) {}

  getUser(username: string): Observable<User> {
    return this.http.get<User>(`${this.authURL}/${username}`);
  }
  
   getAll(): Observable<User[]> {
    return this.http.get<User[]>(`${this.authURL}/getAll`);
  }
  
   updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.authURL}/${user.username}`,user,httpOptions);
  }
  
  
  
  isLoggedIn(){
    return localStorage.getItem('loggedUser')!=null;
  }
 
  logout(): void {
    localStorage.clear();
  }
}