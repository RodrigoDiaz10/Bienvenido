import { Injectable } from '@angular/core';


import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

import { AuthService } from './auth.service';

import { map } from 'rxjs/operators';

import { ClienteInterface } from '../src/app/models/cliente-interface';

import { from } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DataApiService {

  clients: Observable<any>;
  client: Observable<any>;

  constructor( private http: HttpClient, private authService: AuthService ) { }

public selectedCliente:ClienteInterface={
  id:null,
  nombre:'',
  LLlegada:'',
  LSalida:'',
  estado:''
}

  headers: HttpHeaders = new HttpHeaders({
    "Content-Type" : "aplication/json",
    Authorization : this.authService.getToken()
  });

  getAllClients(){
    const url_api = "http://localhost:3000/api/clientes";
    return (this.http.get(url_api));
  }
  getClientById(id: string){
    const url_api = `http://localhost:3000/api/clientes/${id}`;
    return (this.client= this.http.get(url_api));
  }
  saveCliente(cliente:ClienteInterface){
    let token=this.authService.getToken();
    const url_api = `http://localhost:3000/api/clientes?acces_token=${token} `;
    return this.http.post<ClienteInterface>(url_api, cliente,{ headers: this.headers })
    .pipe(map(data => data));
  }

  updateClient(cliente){
    const clienteId = cliente.clienteId;
    const token = this.authService.getToken();
    const url_api = `http://localhost:3000/api/clientes/${clienteId}/?access_token=${token}`;
    return this.http
      .put<ClienteInterface>(url_api, cliente, { headers: this.headers })
      .pipe(map(data => data));
  }
  deleteClient(id: string){
    const token = this.authService.getToken();
    console.log(token);
    const url_api = `http://localhost:3000/api/clientes/${id}/?access_token=${token}`;
    return this.http
      .delete<ClienteInterface>(url_api, { headers: this.headers })
      .pipe(map(data => data));
  }
}
