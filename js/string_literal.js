// string_literal.js

let str = 'Hello'; // "Hello";
str = `Hello`; //문자열 표현 방식 ``

let person = {
    name:'Hong',
    age:20,
    showInfo:function(){
        // return '이름은 ' + this.name + ', 나이는' + this.age;
        return `이름은 ${this.name}, 나이는 ${this.age}`;
    }
}

console.log(person.showInfo());

console.log(`나의 이름은 ${person.name}`);

console.log(`${person.age >= 20 ? '성인' : '청소년'}`);

let strings = 'This\nis\na\nboy';
strings = `This
is
a 
girl`;
strings = 'this \
is'
console.log(strings);

let idx = 'This is an apple'.indexOf('apple');
console.log(idx);

let jm = '950101-1234567';
jm = '9803023341234';

function checkGender(num){
    let number = num.replace('-','');
    number = num.replace(' ','');
    let genderNum = number.charAt(6);

    switch (genderNum) {
        case '1':
        case '3':
            return '남자';
        case '2':
        case '4':
            return '여자'; 

    }
}

let result = checkGender(jm);
console.log(result);


