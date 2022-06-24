//variable.js

console.log("Hello World!!");
document.write("<h3>Hello World!!</h3>");

let num = 0;
num = 'Hello';
num = 10;
num = true;
num = null; // object => class의 인스턴스
let num1; // undefined

console.log(typeof num1);

num1 = 100;
let num2 = 200; // 변수의 선언이 없이 사용(let없이 사용) : 전역객체(window)의 속성
console.log(num1+num2);

console.log(window);

// class Student {
//     String sno;
//     String sname;
//     void showInfo() {
//         return this.sno + this.sname;
//     }
// }

// Student student = new Student();
// student.sno;
// student.showInfo();


// window.alert('안녕하세요');

// 변수 하나에 : 학생이름, 학생번호, 영어, 수학을 담고싶다.
let student = new Object(); // object 타입을 선언하겠다.
student.sno = '22-0123';
student.sname = '홍길동';
student.engScore = 90;
student.mathScore = 80;

console.log(student);

let person = {
    pname: '김민수',
    age: 20,
    height: 175.5,
    showInfo: function() { // 속성이긴한데 object안에서 함수의 기능 사용 => 메소드
        return this.pname +', '+this.age+', '+this.height;
    }
};
person.weight = '68.5'; // 밖에서도 추가 가능

console.log(person);
console.log(person.pname);
console.log(person.showInfo()); // ()를 떼면 속성의 정의를 보여준다.
console.log(person['age']);

let field = 'height';
console.log(person[field]);

// 전체 필드를 for loop .. in
// debugger; 
for(let field in person) {
    console.log(field,'=>',person[field]);
}
console.log(field);

//변수 : me => 이름,취미,연락처,주소, 소개:이름,취미,연락처 반환.
let me = {
    name: '홍길동',
    hobby: '산책',
    tel: '010-111-1111',
    introduce: function(){
        for(let field in me){
            console.log(me[field]);        
        }
    },
    adress: '대구'
};
console.log(me.introduce());

