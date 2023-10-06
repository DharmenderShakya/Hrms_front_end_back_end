export class Employee {
    id:number;
    firstName:string;
    lastName:string;
phone_no:string;
email:string;
profile:string;
work:string;
department:string;
roles:Array<any>;
salary:any;
address:Address;
uploadFile:UploadFile;
quelification:Quelification;
}

export class Leaves{
    description:any;
    employeeName:string;
endDate:any;
id:any;
employeeId:any;
reason:any;
startDate:any;
}
export class Quelification{
        passingYear:any;
        highSchool: any;
        diploma: any;
        degree: any;
}
export class Address{
    
        hno:any;
        city: any;
        state: any;
        pincode: any;
}


export class User{
    userName:string;
    password:string;
}

export class  Leave{
    id:number;
    employee_Name:string;
    reason:string;
    startDate:string;
    endDate:string;
}

export class Project{
    id:number;
    employeeName:string;
    name:string;
    assignDate:string;
    submiDate:string;
    projectDescription:string;
}

export class Salary{
    id:number;
    salary:string;
    employeeName:string;
}

export class LeaveRequest{
    employeeName:string;
    reason:string;
	
    startDate:string;
	
	endDate:string;
	
	description:string;

	employeeId:number;
}

export class Login{
    name:string;
    password:string;
}

export class UploadFile{
    file:any;
}
