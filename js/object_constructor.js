// object_constructor.js

//객체 생성. (생성자함수 => new연산자를 써서 객체생성)
function Student(sno, sname, age) {
    this.sno = sno;
    this.sname = sname;
    this.age = age;

    this.showInfo = function () {
        return '이름은 ' + this.sno + ', 나이는 ' + this.age;
    }

}
let s1 = new Student('22-1111', '홍길동', 19);
let s2 = s1; // 주소값을 같게
s2.sno = '33-3333';
console.log(s1.showInfo());

function Table(param) {
    this.data = param;
    this.fields = ['sname', 'age', 'height', 'weight'];
    
    this.createTable = function () {
        this.tag = '<table border=1>';
        this.createHead();
        this.createBody();
        this.tag += '</table>';

        return this.tag;
    }

    this.createHead = function () {
        this.tag += '<thead><tr>';
        // let str = this.tag;
        this.fields.forEach(val => {
            this.tag += '<th>' + val + '</th>'; //여기서 this는 window
        })
        this.tag += '</tr></thead>';

        // return this.tag;
    }

    this.createBody = function () {
        this.tag += '<tbody>';
        this.data.forEach(obj => {
            this.tag += '<tr>';
            for (let key in obj) {
                this.tag += '<td>' + obj[key] + '</td>';
            }
            this.tag += '</tr>';
        })
        this.tag += '</body>';

        // return this.tag;
    }
}

// function() {this => window} / new 함수 => this : 객체(object) / 이벤트 => this : 이벤트 대상

let data = [{
        sname: '홍길동',
        age: 12,
        height: 197,
        weight: 64.5
    },
    {
        sname: '이길동',
        age: 20,
        height: 160,
        weight: 72.3
    },
    {
        sname: '김길동',
        age: 24,
        height: 175,
        weight: 79.3
    }
]

let t1 = new Table(data);
let str = t1.createTable();
document.write(str);