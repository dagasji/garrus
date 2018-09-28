import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../auth/auth.service';
import { Authoritation, ROLE_CLIENT } from '../auth/authoritation';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '../../../node_modules/@angular/common/http';
import { User } from '../user-profile/user';
import { UserService } from '../user-profile/user.service';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  @Input() user = new User();
  @Input() password2: string;
  constructor(public userService: UserService,
    public router: Router, private toastr: ToastrService) { }

  ngOnInit() {
  }

  create() {
    if (this.user.password === this.password2){
      this.userService.createUser(this.user).subscribe(r=>{
        this.toastr.success("Account created. You can now login.")
        this.router.navigateByUrl("/login");
      },(error: HttpErrorResponse) => {
        this.toastr.error("Username or email already used.");
      });
    }else{
      this.toastr.warning("Passwords must be equal")
    }
  }
}
