import { ToastrService } from 'ngx-toastr';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '../../../node_modules/@angular/common/http';
import { User } from '../user-profile/user';
import { UserService } from '../user-profile/user.service';
import { FormGroup, FormControl, ValidatorFn, FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';

const PasswordValidator: ValidatorFn = (fg: FormGroup) => {
  const p1 = fg.get('password').value;
  const p2 = fg.get('password2').value;

 return p1 !== null && p2 !== null && p1 === p2 
   ? null 
   : { password: true };
};

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;

  constructor(public userService: UserService,
    public router: Router, private toastr: ToastrService,
    private fb: FormBuilder) {
      this.form = this.fb.group({
        username: new FormControl('',Validators.required),
        name: new FormControl('',Validators.required),
        password: new FormControl('',Validators.required),
        password2: new FormControl('',Validators.required),
        email: new FormControl('',[Validators.required,Validators.email]),
        },{
          validator: PasswordValidator
        });
     }

  ngOnInit() {
  }

  create() {
   const user = new User();
   user.email = this.form.controls['email'].value;
   user.username = this.form.controls['username'].value;
   user.password = this.form.controls['password'].value;
   user.name = this.form.controls['email'].value;
    this.userService.createUser(user).subscribe(r=>{
        this.toastr.success("Account created. You can now login.")
        this.router.navigateByUrl("/login");
      },(error: HttpErrorResponse) => {
        this.toastr.error("Username or email already used.");
      });
  }
}
