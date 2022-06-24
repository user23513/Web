// function_table.js

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

//테이블 전체를 생성해주는 함수.
function createTable(aryData) {
    let fields = ['sname', 'age', 'height', 'weight'];
    let tag = '<table border=1>';

    let head = createHead(fields);
    tag += head;

    let body = createBody(aryData);
    tag += body;

    tag += '</table>';
    // <table>...</table>
    return tag;

}
//헤더부분 함수.
function createHead(aryField) {
    let field = aryField;

    let tag = '<thead><tr>';
    field.forEach(val => {
        tag += '<th>' + val + '</th>';
    })
    tag += '</tr></thead>';

    return tag;
}
//바디부분 함수
function createBody(aryData) {
    let data = aryData;

    let tag = '<tbody>';
    data.forEach(object => {
        tag += '<tr>';
        for (let key in object) {
            tag += '<td>' + object[key] + '</td>'
        }
        tag += '</tr>';
    })
    tag += '</tbody>';
    return tag;
}

let str = createTable(data);
console.log(str);
document.write(str);