// function1.js

function sum(n1,n2){
    return n1+n2;
}

console.log(sum(10,20));
console.log(sum('10','20')); //문자열에 +연산자는 연결

function minus(v1, v2){
    return v1-v2;
}

console.log(minus('20','10')); //+연산자빼고는 숫자로 계산

function sumAry(ary) {
    let sum = 0;
    for(let arr of ary) {
        sum += arr;
    }
    return sum;
} 
function sumAry(ary){
    let sum =0;
    for(let i=0; i<numAry.length; i++){
        sum += ary[i];
    }
    return sum;
}
function sumAry(ary) {
    let sum = 0;
    for(let arr in ary) {
        sum -= ary[arr];
    }
    return sum;
} 

let numAry = [20,27,33,19,44];
let result = sumAry(numAry);
console.log('배열의 합: '+result);

result = 0;
numAry.forEach(function(val,idx,ary) {
    console.log(val,idx,ary);
    if(val%2==1){
        result += val;
    }
}); //메소드의 매개값으로 함수 : 콜백함수 / funtion이름이 없으므로 익명함수

console.log('배열의 합: '+result);
