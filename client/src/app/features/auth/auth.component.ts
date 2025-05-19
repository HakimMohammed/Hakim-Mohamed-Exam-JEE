import {Component, OnInit} from '@angular/core';
import {Checkbox} from 'primeng/checkbox';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-auth',
  imports: [
    Checkbox
  ],
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.css'
})
export class AuthComponent implements OnInit{

  formLogin!: FormGroup;

  constructor(private router: Router, private fb: FormBuilder, private service: AuthService, private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.formLogin = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    })
  }

  onSubmit() {
    if (this.formLogin.valid) {
      const username = this.formLogin.value.username;
      const password = this.formLogin.value.password;

      this.service.login(username, password).subscribe({
        next: (data) => {
          this.service.loadProfile(data)
          this.messageService.add({ severity: 'success', summary: 'Login successful' });
          this.router.navigateByUrl("/admin")
        },
        error: () => {
          this.messageService.add({ severity: 'error', summary: 'Login failed' });
        }
      })
    }
    else {
      this.messageService.add({ severity: 'error', summary: 'Invalid form', detail: 'Please fill in all required fields' });
    }
  }

}
