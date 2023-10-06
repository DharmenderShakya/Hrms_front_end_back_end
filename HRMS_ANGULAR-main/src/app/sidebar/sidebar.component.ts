import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
@Input() sideNavStatus: boolean=false;
  list=[
    {
      number:'2',
      name:'Add Employee',
      icon:'fa fa-desktop',
      link:'addemployee'
    },
    {
      number:'3',
      name:'Employee Report',
      icon:'fa fa-bar-chart',
      link:'employee'
    },
    {
      number:'4',
      name:'Add Leave',
      icon:'fa fa-plus-square',
      link:'addleave'
    },
    {
      number:'5',
      name:'Leave Report',
      icon:'fa fa-bar-chart',
      link:'leave'
    },
    {
      number:'5',
      name:'Add Salary',
      icon:'fa fa-plus-square',
      link:'addsalary'
    },
    {
      number:'6',
      name:'Salary Report',
      icon:'fa fa-bar-chart',
      link:'salary'
    },
    {
      number:'7',
      name:'Logout',
      icon:'fa fa-file-o'
    }
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
