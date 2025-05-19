import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Client} from '../../models/interfaces/client.model';
import {API_URL} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  getClients(): Observable<Array<Client>> {
    return this.http.get<Array<Client>>(API_URL + 'clients');
  }

  getClientById(id: number): Observable<Client> {
    return this.http.get<Client>(API_URL + 'clients/' + id);
  }

  addClient(client: Client): Observable<Client> {
    return this.http.post<Client>(API_URL + 'clients', client);
  }

  updateClient(client: Client): Observable<Client> {
    return this.http.put<Client>(API_URL + 'clients/' + client.id, client);
  }

  deleteClient(id: number): Observable<void> {
    return this.http.delete<void>(API_URL + 'clients/' + id);
  }
}
