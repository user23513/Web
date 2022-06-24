// array_method.js

// some: 조건을 만족하는 요소 하나라도 있으면 true/false, 
// every: 조건을 만족하는 요소 '모두' 만족 true/false, 
// find: 조건을 만족하는 한건만 가져오겠습니다. / findIndex:인덱스값
// indexOf: 해당하는 배열요소 => 인덱스 값 반환.(없으면 -1 반환)
// sort(): 배열 정렬.
// split(): 문자열 => 배열.
// join(): 배열 => 문자열.

let idx = "This is a story".indexOf('st');
idx = [1, 2, 3, 4, 5].indexOf(8);

let str = 'The AspectJ weaver applies aspects to Java classes.';
let strAry = str.split(' '); // 반환타입이 배열.
idx = strAry.indexOf('Java');
idx = str.search(/java/gi);
// console.log('idx: ', idx);

let names = ['박은지', '윤정은', '박지혜', '김나희'];
idx = names.indexOf('김나희');

let result = names.find(function (val, idx, ary) {
    return val == '김나희';
});


result = [6, 4, 3, 21, 14].some((val, idx, ary) => {
    return val > 20; // 만족하는 요소(값)가 하나라도 있으면 true
});

result = [6, 4, 3, 21, 14].every((val, idx, ary) => {
    console.log(val, idx, ary);
    return val % 2 == 0;
})
console.log(result);

console.clear();
let tempAry = [];
for (let i = 0; i < 15; i++) {
    let temp = parseInt(Math.random() * 10) + 1; // 0<=x<1 => 1 ~ 10 까지의 임의 수.
    // console.log(temp);
    tempAry.push(temp);
}
console.log(tempAry);

console.clear();
// 1. tempAry 배열의 값이 다 짝수인지 확인
result = tempAry.every(val => val % 2 == 0);
// 2. tempAry 배열의 값 중에 3의 배수가 존재 확인
result = tempAry.some(val => val % 3 == 0);
// 3. 5보다 큰 값이 있으면 그 값을 반환
result = tempAry.find(val => val > 5);
// 배열 정렬
result = [4, 6, 3, 21, 14].sort(function (a, b) {
    // console.log(a,b)
    // if(a < b) {
    //     return -1; //오름차순
    // }else{
    //     return 1;  
    // }
    console.log(a, b);
    return a - b;
});

console.clear();
let objAry = [{
    name: '홍길동',
    age: 18
}, {
    name: '김민수',
    age: 20
}, {
    name: '박세민',
    age: 19
}];

console.log('홍' < '박');
result = objAry.sort(function (a, b) {
    // if (a.name < b.name) {
    //     return -1;
    // } else {
    //     return 1;
    // }
    // return a.name < b.name ? -10 : 10; //이름오름차순
    return a.age < b.age ? -10 : 10;
});

result = ['홍길동', '김길동', '이길동'].join(':');
names = '권소정 ,김하은, 유선희,김가윤'; //권소정,김가윤,김하은,유선희
result = names.split(/\s*\,\s*/).sort((a, b) => a < b ? -1 : 1).join();
console.log(result);

// result = tempAry.filter(val => val > 5);

strAry = 'Littering'.split(''); // 문자를 하나하나씩 구분
let cnt = 0;
strAry.forEach(val => {
    cnt += val == 't' ? 1 : 0;
    // console.log(cnt);
});

cnt = strAry.reduce((accum, curr) => {
    accum += curr == 't' ? 1 : 0;
    return accum;
}, 0);
// console.log('cnt: ',cnt);

const str3 = '아주, 아주 여러해 전 ,  어느 바닷가 왕국에,당신도 알지 모를 한 소녀가 살았다네 . 그녀 이름은 애너벨 리';
console.log(str3.split(', '));
console.log(str3.split(/\s*[\,|\.]\s*/));