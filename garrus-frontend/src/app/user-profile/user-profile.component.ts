import { AuthService } from '../auth/auth.service';
import {User} from './user';
import {UserService} from './user.service';
import {Component, OnInit, Input} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  @Input() user: User;
  @Input() password: string;
  @Input() password2: string;
  constructor(private route: ActivatedRoute,
              private userService: UserService,
            private authService: AuthService,
            private toastr: ToastrService) {}

  ngOnInit() {
    const loggedUser = JSON.parse(localStorage.getItem('loggedUser'));
    if (loggedUser != null) {
      this.userService.getUser(loggedUser.username).subscribe(res => this.user = res);
    } else {
      this.user = new User();
    }
  }
  
  save(){
    if (this.user.password === this.password2){
      this.userService.updateUser(this.user).subscribe(r=>{
        this.toastr.success("Profile saved")
      });
    }else{
      this.toastr.warning("Passwords must be equal")
    }
  }

}
