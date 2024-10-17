"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Employee = /** @class */ (function () {
    //private eid:number =101;
    // private ename:string = "tom";
    // readonly city:string = "pune"
    function Employee(eid, ename) {
        //this.eid = eid;
        //this.ename = ename;
        this.eid = eid;
        this.ename = ename;
    }
    Employee.prototype.get = function () {
        console.log(this.eid + " " + this.ename);
        //console.log("city before "+this.city);
        // this.city = "hyderabad";
        // console.log("city after "+this.city);
    };
    Employee.prototype.getCustomer = function () {

        
        var data = { "cid": 501, "cname": "javeed", "amount": 8000 };
        //const customer = new Customer();
        console.log(data);
    };
    return Employee;
}());
var emp = new Employee(111, "javeed");
console.log(emp);
emp.get();
emp.getCustomer();
