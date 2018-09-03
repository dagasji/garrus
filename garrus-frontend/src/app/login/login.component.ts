import { UsuarioOficinaService } from './../../../../../valf/frontend/src/app/usuario-oficina.service';
import { OficinaService } from './../../../../../valf/frontend/src/app/oficina.service';
import { ClienteService } from './../../../../../valf/frontend/src/app/cliente.service';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../auth/auth.service';
import { Authoritation } from '../auth/authoritation';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '../../../node_modules/@angular/common/http';

const ROLE_CLIENT = 'ROLE_CLIENT';
const ROLE_OFFICE = 'ROLE_OFFICE';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @Input() user: Authoritation = new Authoritation();

  constructor(public authService: AuthService,
    private clienteService: ClienteService,
    private usuarioOficinaService: UsuarioOficinaService,
    public router: Router, private toastr: ToastrService) { }

  ngOnInit() {
  }

  login() {
    this.authService.login(this.user).subscribe(res => {
      if (res != null) {
        localStorage.setItem('loggedUser', JSON.stringify(this.user));
        localStorage.setItem('role', this.user.role);
        if (this.user.role === ROLE_CLIENT) {
          this.clienteService.get(this.user.rut).subscribe(r => {
            localStorage.setItem('userInfo', JSON.stringify(r));
            localStorage.setItem('name', r.razonSocial);
          });
        } else if (this.user.role === ROLE_OFFICE) {
          this.usuarioOficinaService.get(this.user.rut).subscribe(r => {
            localStorage.setItem('userInfo', JSON.stringify(r));
            localStorage.setItem('name', r.nombre);
          });

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
