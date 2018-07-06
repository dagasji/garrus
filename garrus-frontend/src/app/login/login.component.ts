import {AuthService} from '../auth/auth.service';
import {User} from '../auth/user';
import {Component, OnInit, Input} from '@angular/core';
import {Router} from '@angular/router';
import {NotificationsComponent} from '../notifications/notifications.component'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @Input() user: User = new User();

  constructor(public authService: AuthService, public router: Router) {}

  ngOnInit() {
  }

  login() {
    this.authService.login(this.user).subscribe(res => {
      if (res != null) {
         localStorage.setItem('loggedUser',JSON.stringify(res));
        localStorage.setItem('name',res.name);
        const redirect = this.authService.redirectUrl ? this.authService.redirectUrl : '/vehicles';
        // Redirect the user
        this.router.navigate([redirect]);
      }
      else{ 
        NotificationsComponent.showNotification('top','right','Datos incorrrectos');
      }
    });
  }
}
