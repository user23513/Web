// variable2.js
var li; //hostiong 기능

let ary = new Array(); 
ary[0] = 10;

ary = [20,30,15,27]; //선언하고 초기화
ary[ary.length] = 50;
ary[ary.length] = 60;
ary[ary.length] = 70;
ary[10] = 100;


console.log(typeof ary[7]);

for(let i = 0; i<ary.length; i++) {
    console.log(i+'번째 ' + ary[i]);
}

ary = ['사과','바나나','고구마','수박',32];

console.clear(); // 로그 지우기
document.write('<ul>');
for(let val of ary) {
    console.log(val);
    document.write('<li>'+val+'</li>');
}
document.write('</ul>');

ary = [
    {name:'홍길동',age:20,phone:'010-1111-1111'},
    {name:'김길동',age:30,phone:'010-2222-1111'},
    {name:'이길동',age:40,phone:'010-3333-1111'},
    {name:'박길동',age:50,phone:'010-4444-1111'}
]

// document.write('<ul>');
// for(let person of ary) {
//     document.write('<li>'+person['name']+','+person['phone']+'</li>');
// }
// document.write('</ul>');

let str = '';
str += '<ul>';
for(let person of ary) {
    str += '<li>이름: '+person['name']+', 연락처: '+person['phone']+', 나이: '+person['age']+'</li>';
}
str += '</ul>';

str += '<table border=1>';
str += '<tr><td>이름</td><td>연락처</td><td>나이</td></tr>';
for(let person of ary) {
    str += '<tr>';
    str += '<td>'+person['name']+'</td>';
    str += '<td>'+person['phone']+'</td>';
    str += '<td>'+person['age']+'</td>';
    str += '</tr>';
}
str += '</table>';

console.log(str);
document.write(str);

const v1 ='hello';
// v1 = 'world';

// 원시타입 vs 참조타입
//원시타입
let n1 = 10; 
let n2 = n1;
n1 = 20;

//참조타입
let o1 = {name:'one'};
let o2 = o1;
o2.name = 'two';
o1.name = 'tree';

console.log(n1, n2);
console.log(o1, o2);

const obj = {
    sno:'22-12345',
    sname:'Hong'
}
obj.sno='11-11111'; //obj의 상수변수에 값을 새롭게 선언X -> obj 참조하고 있는 속성의 값을 변경하는 것은 가능
// obj =''; // 새로운 값을 할당 => 오류
console.log(obj);

// var vs let -> 변수선언
// var 변수선언 : 변수의 scope => 전역변수/지역변수
var var1 = 'hello'; // 전역변수 -> 스크립트 전역에서 값을 가짐
var var1 = 'new hello';

function localFnc(){ //지역변수(local variable) -> 함수안에서만 값을 가짐
    var var2 = 'nice';
    console.log(var2);
    console.log(var1);
}
localFnc(); //함수호출이 되어야 실행이 됨
console.log(var1);
// console.log(var2);

//let 변수선언
let var3 = 'hello';
// let var3 = 'new hello'; 같은 변수 사용 불가능
{ //블럭안에서는 같은 변수 사용가능하지만 블럭 지나면 사라짐
    let var3 = 'new hello';
    console.log('block안: '+ var3);
}

function localFnc2(){ 
    let var4 = 'nice';
    console.log(var4);
    console.log('fun: ' + var3);
}
localFnc2(); 
console.log('var3: '+var3);
// console.log(var2);

// console.log(l1);
var l1 = 'var : hello';
var l1 = 'var : hello2';
console.log(l1);

var num;
for( num of ary) {
    console.log('안'+num);
}
console.log('밖'+num);




