// 1. JavaScript Fundamentals

// 1.1 Hello, World!
console.log("Hello, world!");

// 1.2 Code Structure
// Single-line comment

/*
  Multi-line comment
*/

// Semicolons are optional, but it's a good practice to use them.
console.log("This is a statement");
console.log("Statements can be on separate lines or on the same line.");
console.log("Like this.");

// 1.3 The Modern Mode, "use strict"
"use strict";

// In strict mode, you can't use undeclared variables.
let x = 3.14;
console.log("strict variable")
console.log(x);

// 2. Variables
let message = "Hello, world!";
console.log(message);

let user = "John", age = 30, isAdmin = true;

console.log(user);
console.log(age);
console.log(isAdmin);

// 3. Data Types
let name2 = "John"; // string
let age1 = 30; // number
let isStudent = false; // boolean

console.log(typeof name2); // "string"
console.log(typeof age); // "number"
console.log(typeof isStudent); // "boolean"

// Undefined
let und;
console.log(typeof und); // "undefined"

// Null
let n = null;
console.log(typeof n); // "object" (a known quirk in JavaScript)

// 4. Interaction: alert, prompt, confirm execute in html file
/*alert("Hello, world!"); // Displays a message

age = prompt("How old are you?", 18); // Asks the user to input something
alert(`You are ${age} years old.`);

isAdmin = confirm("Are you an admin?"); // Asks for confirmation
alert(isAdmin); // true if OK is pressed, false if Cancel is pressed*/

// 5. Type Conversions
let value = true;
console.log(typeof value); // boolean

value = String(value); // now value is a string "true"
console.log(typeof value); // string

let str = "123";
let num = Number(str); // becomes a number 123
console.log(typeof num); // number

// 6. Basic Operators, Maths
x = 5;
let y = 2;

console.log(x + y); // 7
console.log(x - y); // 3
console.log(x * y); // 10
console.log(x / y); // 2.5
console.log(x % y); // 1 (remainder)
console.log(x ** y); // 25 (exponentiation)

// 7. Comparisons
console.log(5 > 3); // true
console.log(5 == "5"); // true (loose equality, converts types)
console.log(5 === "5"); // false (strict equality, no type conversion)
console.log(5 != "5"); // false
console.log(5 !== "5"); // true

// 8. Conditional Branching: if, '?'
age = 18;

if (age < 18) {
    console.log("Too young.");
} else if (age == 18) {
    console.log("Just turned adult.");
} else {
    console.log("Adult.");
}

// Ternary operator
message = age >= 18 ? "Adult" : "Not an adult";
console.log(message);

// 9. Logical Operators
let isAdult = true;
let hasTicket = true;

console.log(isAdult && hasTicket); // true (AND)
console.log(isAdult || hasTicket); // true (OR)
console.log(!isAdult); // false (NOT)

// 10. Nullish Coalescing Operator '??'
user = undefined;
console.log(user ?? "Anonymous"); // "Anonymous"

user = "John";
console.log(user ?? "Anonymous"); // "John"

// 11. Loops: while and for

// 11.1 while Loop
let i = 0;
while (i < 5) {
    console.log(i);
    i++;
}

// 11.2 for Loop
for (let i = 0; i < 5; i++) {
    console.log(i);
}

// 12. The "switch" Statement
let day = 3;
switch (day) {
    case 1:
        console.log("Monday");
        break;
    case 2:
        console.log("Tuesday");
        break;
    case 3:
        console.log("Wednesday");
        break;
    default:
        console.log("Unknown day");
}

// 13. Functions
function greet(name) {
    console.log("Hello, " + name);
}

greet("Alice"); // Hello, Alice

// 14. Function Expressions
let greetExpression = function(name) {
    console.log("Hello, " + name);
};

greetExpression("Bob"); // Hello, Bob

// 15. Arrow Functions, The Basics
let sum = (a, b) => a + b;
console.log(sum(3, 4)); // 7

let greetArrow = name => console.log("Hello, " + name);
greetArrow("Charlie"); // Hello, Charlie

// 16. JavaScript Specials

// 16.1 Automatic Semicolon Insertion
// JavaScript automatically inserts semicolons in some cases.
x = 5
y = 10

console.log(x + y) // No semicolons, but this still works.

// 16.2 Dynamic Typing
let variable = "Hello"; // string
console.log(typeof variable); // "string"

variable = 123; // number
console.log(typeof variable); // "number"

// 16.3 Global Object
// 'window' is the global object in browsers
// it requires browser execute in html file
// program console.log(window.alert("Hello, world!"));

// In Node.js, the global object is 'global'
