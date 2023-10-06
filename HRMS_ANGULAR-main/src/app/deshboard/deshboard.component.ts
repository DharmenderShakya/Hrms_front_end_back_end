import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-deshboard',
  templateUrl: './deshboard.component.html',
  styleUrls: ['./deshboard.component.css']
})
export class DeshboardComponent implements OnInit {
  showSidebar = true;

  toggleSidebar() {
    this.showSidebar = !this.showSidebar;
    console.log("-------------------------"+this.showSidebar);
  } 
  constructor() { }

  ngOnInit(): void {
  }

}
