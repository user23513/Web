// function2.js

//함수정의문
function sumAry(ary) { // ary => 매개변수(parameter) :값이 아니고 이 함수안에서 사용하는 변수
    let result = 0;
    for(let i =0; i<ary.length; i++) {
        result += ary[i];
    }
    return result;
}
//const sumAry = function(ary) {...} => 함수정의문 -> 함수표현식처리
let args = [1,2,3,4,5]; // 매개값(argument)
console.log(sumAry(args)); // 실행문 호출

let arrNum = [1,2,3];
console.log(sumAry(arrNum));

//함수표현식
const sum = function(num1,num2) {
    if(!num1) { //값이 안들어오면 undefined -> flase의 의미 : null, 0,''
        num1 = 0;
    }
    num2 = num2 == undefined ? 0 :num2;
    return num1+num2;
}
console.log(sum(40)); // 함수정의문() => 실행하겠다.

const sum2 = sum;
console.log(sum2(10,20));

console.log(sumAry);

//함수표현식
const sayHello = name => 'Hello ' + name; // 화살표함수
//메소드의 매개값으로 함수가 사용되어지는 경우(콜백함수)
console.log(sayHello('홍길동'));

let arr = ['홍길동','김길동','이길동'];
arr.forEach((val/*,idx,ary*/)=>console.log(sayHello(val)));

arrNum = [29,34,12,55,29,42];
//1.배열의 각 요소중에 짝수의 값만 더하도록 sumEven(args);
//2.배열의 홀수번째 요소의 합 sumOdd(args);
function sumEven(args) {
    let sum = 0;
    args.forEach(val => {
        if(val%2==0){
            sum += val;
        }
    })
    return sum;
}

function sumOdd(args) {
    let sum = 0;
    args.forEach((val,idx) => {
        if(idx%2==1){
            sum += val;
        }
    })
    return sum;
}
console.log(sumEven(arrNum));
console.log(sumOdd(arrNum));

// let age = prompt("나이를 알려주세요.", 18);

// let welcome = (age < 18) ?
//   () => alert('안녕') :
//   () => alert("안녕하세요!");

// welcome();

// let a = if(age<18){
//     console.log('안녕');
// }else {console.log('안녕하세요')};

let b = (age<18) ? console.log('hi') : console.log('hello');