import { restBaseUrl } from 'environments/environment';
import { Authoritation } from './authoritation';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AuthService {
  user: Authoritation;

  // store the URL so we can redirect after logging in
  redirectUrl: string;

  private authURL = restBaseUrl + 'public/user/login';


  constructor(public jwtHelper: JwtHelperService,
    private http: HttpClient) { }
    
  public getToken(): string {
    return localStorage.getItem('token');
  }

  login(user: Authoritation): Observable<Authoritation> {
    return this.http.post<Authoritation>(this.authURL, user, httpOptions);
  }

  isLoggedIn() {
    const token = localStorage.getItem('token');
    return !this.jwtHelper.isTokenExpired(token);
  }

  logout(): void {
    localStorage.clear();
  }
}