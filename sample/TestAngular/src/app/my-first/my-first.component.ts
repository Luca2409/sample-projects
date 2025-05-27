import {Component, OnInit} from '@angular/core';
import {TestService} from '../service/test.service';
import {ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {Test} from '../models/accounts-representation';

@Component({
  selector: 'app-my-first',
  imports: [
    ReactiveFormsModule, CommonModule
  ],
  template: `

    <h1> {{ test.balances?.available }}</h1>



  `,
  standalone: true,
  styleUrl: './my-first.component.css'
})
export class MyFirstComponent implements OnInit{

  constructor(private testService: TestService) {
  }

  apidata: string= '';

  name: string= '';

  test = new Test();

  ngOnInit(): void {
    this.testService.getData().subscribe({
      next: (data) => {
        console.log(data);
        this.test.accountId = data.accountId;
        this.test.name = data.name;
        this.test.balances = data.balances;
        this.test.officialName = data.officialName;
      }
    });
  }

}
