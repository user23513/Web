// for_loop.js

// 배열관련 반복되는 메소드
// forEach: void, map: [배열] A -> A', filter: [배열] A -> a, reduce: 문자열,Number,[배열],{}

let ary = [3,5,8,9,12]; // 배열객체: new Array();
ary.push(5); // <-> pop();
ary.unshift(7); // <-> shift();
ary.splice(3,1);
console.log(ary);

let newAry = [];
// 1.forEach
ary.forEach(firstCallBack);

function firstCallBack(elem){
    // console.log(elem)
    newAry.push(elem);
}

// 2.map
let result = ary.map(val => {
    return val*2
}); // A -> A'

// 3.filter A -> a
result = ary.filter((val,idx,arry) => idx > 3); // true값만 return 

// 4. reduce A -> 문자열, Number, [], {} 초기값을 어떻게 정하느냐에 따라
result = ary.reduce((accum, curr, currIdx, arry) => {
    console.log(accum,curr,currIdx);
    return accum+curr;
}, 0);

result = ary.reduce((accum, curr)=>{
    console.log(accum, curr);
    accum.push(curr*2);
    return accum;
}, []); // 2.map과 같은 기능

result = ary.reduce((accum,curr,currIdx)=>{
    if(currIdx > 3) {
        accum.push(curr*2);
    }
    return accum;
},[]); // filter,map

console.log('result',result);


