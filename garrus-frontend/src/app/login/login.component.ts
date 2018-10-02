import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../auth/auth.service';
import { Authoritation, ROLE_CLIENT } from '../auth/authoritation';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '../../../node_modules/@angular/common/http';
import { UserService } from '../user-profile/user.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @Input() user: Authoritation = new Authoritation();
  forgot = false;
  constructor(public authService: AuthService, private userService: UserService,
    public router: Router, 
    private toastr: ToastrService) { }

  ngOnInit() {
  }
  fogotPassword(){
    this.forgot=true;
  }

  resetPassword(){
    this.userService.resetPassword(this.user.username).subscribe(r => {
      this.toastr.success("An email has been sent to your email with your new password.");
      this.forgot = false;
    });
  }
  login() {
    this.authService.login(this.user).subscribe(res => {
      if (res != null) {
        localStorage.setItem('loggedUser', JSON.stringify(this.user));
        localStorage.setItem('role', this.user.role);
        if (this.user.role === ROLE_CLIENT) {
           //You could do something here
        }
        localStorage.setItem('token', res.token);
        const redirect = this.authService.redirectUrl ? this.authService.redirectUrl : '/';
        // Redirect the user
        this.router.navigate([redirect]);
      }
      else {
        this.toastr.warning('Bad credentials');
      }
    },
      (error: HttpErrorResponse) => {
        this.toastr.error("Bad credentials");
      });
  }
}
