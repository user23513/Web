// array_basic.js

let arr = []; // new Array();
arr[0] = 'Hello';
arr[1] = 100;
arr[2] = true;

delete arr[1];

console.log(arr);
for(let i = 0; i<arr.length; i++){
    console.log(arr[i]);
}

//확장 for
for(let val of arr) {
    console.log(val);
}

//forEach()
arr.forEach((val,idx)=>{
    console.log(`${idx} => ${val}`) // 배열의 값이 undefined면 반복에서 제외.
});

arr.push('Apple'); // 제일 뒤에 추가
arr.unshift('Banana'); // 제일 앞에 추가
arr.pop(); // 마지막 삭제.
arr.shift(); // 첫번째 삭제.
arr.splice(0, 1); // 추가,수정,삭제

console.log(arr);