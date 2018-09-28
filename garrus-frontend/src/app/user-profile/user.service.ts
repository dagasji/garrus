import {User} from './user';
import {Injectable} from '@angular/core';

import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UserService {
  user: User;

  private authURL = 'http://localhost:8080/private/user';

  constructor(
    private http: HttpClient) {}

  getUser(username: string): Observable<User> {
    return this.http.get<User>(`${this.authURL}/${username}`);
  }
    
   updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.authURL}/${user.username}`,user,httpOptions);
  }
 
  createUser(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/public/user',user,httpOptions);
  }
  
 
}