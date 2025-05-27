import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AccountsResponse} from '../models/accounts-representation';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http: HttpClient) {
  }

  getData() {
    const url = 'http://localhost:8080/api/accounts/balance?id=1';
    return this.http.get<AccountsResponse>(url);
  }

}
