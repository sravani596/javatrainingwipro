
import { Customer } from './customer';

class Employee{

   //private eid:number =101;
   // private ename:string = "tom";

   
  // readonly city:string = "pune"

   constructor(private eid,private ename){
   

    //this.eid = eid;
    //this.ename = ename;

    }


   

    get(){


           
        console.log(this.eid +" "+this.ename);

        //console.log("city before "+this.city);

       // this.city = "hyderabad";

       // console.log("city after "+this.city);

    }


    getCustomer(){

        const c1:Customer;

         const data:Customer =     {"cid":501,"cname":"javeed","amount":8000}

            //const customer = new Customer();

                console.log(data)


    }

}

 const  emp = new Employee(111,"javeed");

 console.log(emp)

    emp.get();

    emp.getCustomer();