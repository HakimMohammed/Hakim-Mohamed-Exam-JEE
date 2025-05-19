import {Component, OnInit} from '@angular/core';
import {ClientService} from '../../core/services/client.service';
import {Client} from '../../models/interfaces/client.model';
import { TableModule } from 'primeng/table';
import {Card} from 'primeng/card';
import {IconField} from 'primeng/iconfield';
import {InputText} from 'primeng/inputtext';
import {InputIcon} from 'primeng/inputicon';

@Component({
  selector: 'app-clients',
  imports: [TableModule, Card, IconField, InputText, InputIcon],
  templateUrl: './clients.component.html',
  styleUrl: './clients.component.css'
})
export class ClientsComponent implements OnInit{

  constructor(private clientService: ClientService) { }

  clients! : Array<Client>;
  loading: boolean = true;

  loadClients() {
    this.clientService.getClients().subscribe(
      (data: Array<Client>) => {
        this.clients = data;
        this.loading = false;
      },
      (error) => {
        console.error('Error loading clients', error);
        this.loading = false;
      }
    );
  }

    ngOnInit(): void {
        this.loadClients();
    }

}
