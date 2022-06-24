let data = `[{"id":1,"first_name":"Wye","last_name":"Dussy","email":"wdussy0@netlog.com","gender":"Male","salary":3884},
{"id":2,"first_name":"Matias","last_name":"Loadwick","email":"mloadwick1@engadget.com","gender":"Male","salary":2422},
{"id":3,"first_name":"Cassandry","last_name":"Linney","email":"clinney2@mysql.com","gender":"Female","salary":3385},
{"id":4,"first_name":"Berti","last_name":"Gerok","email":"bgerok3@photobucket.com","gender":"Female","salary":3749},
{"id":5,"first_name":"Yance","last_name":"Agnew","email":"yagnew4@tinyurl.com","gender":"Male","salary":4501},
{"id":6,"first_name":"Jethro","last_name":"Covert","email":"jcovert5@google.de","gender":"Male","salary":4773},
{"id":7,"first_name":"Thalia","last_name":"Snoxill","email":"tsnoxill6@mail.ru","gender":"Female","salary":3757},
{"id":8,"first_name":"Drud","last_name":"Alan","email":"dalan7@163.com","gender":"Male","salary":2948},
{"id":9,"first_name":"Rollo","last_name":"Cuerda","email":"rcuerda8@wikia.com","gender":"Male","salary":3418},
{"id":10,"first_name":"Michele","last_name":"Grzesiewicz","email":"mgrzesiewicz9@4shared.com","gender":"Male","salary":4727},
{"id":11,"first_name":"Jasmine","last_name":"Sharply","email":"jsharplya@google.it","gender":"Female","salary":1619},
{"id":12,"first_name":"Frederick","last_name":"Barehead","email":"fbareheadb@intel.com","gender":"Male","salary":2970},
{"id":13,"first_name":"Berny","last_name":"Rainton","email":"braintonc@elegantthemes.com","gender":"Male","salary":3738},
{"id":14,"first_name":"Neile","last_name":"Malyj","email":"nmalyjd@clickbank.net","gender":"Non-binary","salary":2229},
{"id":15,"first_name":"Ethelred","last_name":"Nunes Nabarro","email":"enunesnabarroe@list-manage.com","gender":"Male","salary":1022}]`;

let objAry = JSON.parse(data); //JSON.parse() : 문자열 => 오브젝트.
console.log(data);
console.log(objAry);

let over3000 = objAry.filter((val, idx) => {
    return val.salary > 3000;
}).map((val, idx) => {
    let obj = {};
    obj.name = `${val.last_name},${val.first_name}`;
    obj.sal = val.salary;
    return obj;
});

console.log(over3000);

console.clear();
// Female 값 평균값을 기능
let avg;
let sum = 0;

let fe = objAry.filter(val => val.gender == 'Female');
fe.forEach(obj => {
    sum += obj.salary;
});
avg = sum / fe.length;

console.log(`여사원의 급여평균 ${avg}`);

let salaries = [];

objAry.forEach(obj => salaries.push(obj.salary));
// salaries = objAry.map(val => val.salary);

// objAry.map(obj => {
//     sal = obj.salary;
//     console.log(salaries);
//     return salaries.push(sal);
// });
console.log('sal:', salaries);

function getMaxValue(ary) {
    //배열요소에서 제일 큰값을 반환하는 함수.
    let max = 0;
    for (let i = 0; i < ary.length; i++) {
        if (max < ary[i]) {
            max = ary[i];
        }
    }
    return max;
}
let maxVal = getMaxValue(salaries);
console.log(`가장 큰값 : ${maxVal}`);

function sortAscend(ary) {
    //오름차순 정렬하는 함수
    for (let i = 0; i < ary.length; i++) {
        for (let j = i; j < ary.length; j++) {
            if (ary[i] > ary[j]) {
                let a = ary[i];
                ary[i] = ary[j];
                ary[j] = a;
            }
        }
    }
    return ary;
}
sortAscend(salaries);
console.log(salaries);

// console.clear();

// reduce 메소드
salaries.reduce(function (accum, curr, curIdx, ary) {
    console.log(`누적 ${accum}, current 값 ${curr} => 두 수의 합 ${accum+curr}`);
    return curr + accum;
}, 0); // map,filter 메소드

result = salaries.reduce(function (accum, curr) {
    accum.push(curr); //배열에 추가
    return accum;
}, []);

console.log(result);

console.clear();
//<ul><li>Apple</li><li>Banana</li><li>Cherry</li></ul>
result = ['Apple', 'Banana', 'Cherry'].reduce((accum, curr, curIdx, ary) => {
    if (curIdx == 0) {
        accum = '<ul>';
    }
    accum += `<li>${curr}</li>`;
    if (curIdx == ary.length - 1) {
        accum += '</ul>';
    }
    console.log(accum, curr);
    return accum;
}, '');

console.log(result);
document.write(result);

console.clear();
result = [3, 2, 4, 1, 5].reduce(function (accum, curr) {
    if (accum > curr) {
        return curr
    } else {
        return accum;
    }
}, Number.MAX_SAFE_INTEGER); //max 값을 반환

result = [3,2,4,1,5].reduce((accum, curr)=>{
    return accum+curr
}, 0); // 합을 구하기


let count=0;
result = [3,2,4,1,5].reduce((accum, curr, curIdx,ary)=>{
    if(curIdx == ary.length-1){ //마지막 순번일 경우에만
        return (accum+curr)/ary.length;
    }
    // count++;
    return accum+curr;
}, 0); // 평균 구하기
console.log(`result : ${result}`);

