//function.js

function sum(number1, number2) {
    let result = number1 + number2;
    console.log(result);
    return result; //undefined. return문이 없으면 
}
console.log(sum(10,20));

function makeTd(val) {
   return '<td>' + val + '</td>';
}

function makeTr(val) {
    return '<tr>' + val + '</tr>';
}

let values = ['Hong','Hwang','Choi'];

let str = '<table border=1>';
for(let val of values) {
    let td = makeTd(val); //<td>Hong</td>...
    str += makeTr(td);
}
str += '</table>';
document.write(str);