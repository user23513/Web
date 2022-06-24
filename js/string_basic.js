// string_basic.js

let str = 'Hello'; // 문자열
let str1 = new String('Hello'); // 문자열 객체

console.log(str == str1);  // 값만 비교
console.log(str === str1); // 값과 타입 모두 비교
console.log(str === str1.valueOf()); // 객체를 문자열로 변경시키겠다. 

let num = new Number(123); //숫자 객체
let num1 = 123;
console.log(num == num1);
console.log(num === num1);
console.log(num.valueOf() === num1);
console.log(num.valueOf()); // valueOf() -> 기본데이터타입으로 변환
console.log('123');

//원시타입 : string, number, boolean, undefined
//객체타입 : 함수, object({name:?,age:?}), 배영, null

console.log("Hello".trimStart());
console.log("This is the only stroy".slice());
console.log("This is the only stroy".substr(8,1));

const calc1 = '1+2*3';
const calc2 = new String('1+2*3');
console.log(eval(calc1));
console.log(eval(calc2.valueOf()));

// indexOf()

// search()

// only,story
let regStr = "bad MORNING, GOOD AFTERNOON, goodevening, and good night";
console.log(regStr.replace(/good\s/gi,'bad '));

const obj = {key:'data',value:15};
console.log(obj.key.toString());
console.log(obj.value.toString());

const a = 'good morning, good afternoon, good evening, and good night';
console.log(a.indexOf('even'));
console.log(a.lastIndexOf('good'));
console.log(a.lastIndexOf('dawn'));
console.log(a.indexOf('good',15))

console.log(a.charAt(30))
console.log(a.includes('even'))
console.log(a.includes('dawn'))

const b = 'hi Hello hi hi'
console.log(b.toUpperCase().replace('hi','bye'))
console.log(b.replace(/hI/gi,'bye'))

const st1 = 'hello';
const st2 = ' world';

console.log(st1+st2);
console.log(st1.concat(st2));
console.log(''.concat(st1,st2));

let strarr = ['good', ' ','morning','!'];
console.log(''.concat(...strarr));

var st3 = '    how are you     to    day  everyone.   ';
console.log(st3.trim());
console.log('+없이: ',st3.replace(/\s/g, ''));
console.log(st3.split(' ').filter(val => val != '').join(' '));
console.log('+있이: ',st3.replace(/\s+/g,' '));


let arr = ['김','이','박'];
console.log(arr.join(' '));

const st4 = "apple banana   orange";
const arr2 = st4.split(' ');
console.log(arr2)


