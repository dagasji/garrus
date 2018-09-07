import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../auth/auth.service';
import { Authoritation, ROLE_CLIENT } from '../auth/authoritation';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '../../../node_modules/@angular/common/http';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @Input() user: Authoritation = new Authoritation();

  constructor(public authService: AuthService,
    public router: Router, private toastr: ToastrService) { }

  ngOnInit() {
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
        this.toastr.warning('Datos incorrrectos');
      }
    },
      (error: HttpErrorResponse) => {
        this.toastr.error("Ha habído un error en la comunicación.");
      });
  }
}
