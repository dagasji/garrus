import {Permission} from '../auth/permission';
import { AuthService } from '../auth/auth.service';
import {User} from './user';
import {UserService} from './user.service';
import {Component, OnInit, Input} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  @Input() user: User;
  permissions: Permission[];
  constructor(private route: ActivatedRoute,
              private userService: UserService,
            private authService: AuthService) {}

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('loggedUser'));
    if (this.user != null) {
      this.userService.getUser(this.user.name).subscribe(res => this.user = res);
    } else {
      this.user = new User();
    }
    this.authService.getAvaliablePermissions().subscribe(res => this.permissions = res);
  }
  
  save(){
    this.userService.updateUser(this.user).subscribe(r=>{});
  }

}
