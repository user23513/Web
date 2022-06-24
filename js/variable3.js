// variable3.js

let str = '<table id="table1" border=1>';
for (let i = 1; i < 10; i++) {
    str += '<tr>';
    str += '<td>' + 2 + '</td>';
    str += '<td>' + '*' + '</td>';
    str += '<td>' + i + '</td>';
    str += '<td>' + '=' + '</td>';
    str += '<td>' + 2 * i + '</td>';
    str += '</tr>';
}
str += '</table>';
document.write(str);

//달력
let mon = 7;
showCalendar(6)

function showCalendar(month) {
let days = ['일','월','화','수','목','금','토'];
let str2 = '<table border=1 id="table2"><caption>'+month+'월달력</caption><tr>';
for(let day of days){
    str2 += '<th>'+day+'</th>'
}
str2 += '</tr><tr>';
let vtd = getFirstDay(month); // 4
for(let i =1; i<vtd; i++) {
    str2 += '<td></td>';
}
for (let i = 1; i <= getLastDate(month); i++) {
    str2 += '<td>' + i + '</td>';
    if ((vtd-1 + i) % 7 == 0) {
        str2 += '</tr><tr>';
    }
}
str2 += '</tr></table>';
document.write(str2);
}


console.log(getFirstDay(6));

function getLastDate(mon) {
    //1,3,5,7,8,10,12 => 31
    //4,6,9,11 => 30
    //2 => 28
    switch (mon) {
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        case 2:
            return 28;
        default:
            return 31;
    }
    
}

function getFirstDay(mon) {
    switch (mon) {
        case 1:
            return 7;
        case 2:
            return 3;
        case 3:
            return 3;
        case 4:
            return 6;
        case 5:
            return 1;
        case 6:
            return 4;
        case 7:
            return 6;
        case 8:
            return 2;
        case 9:
            return 5;
        case 10:
            return 7;
        case 11:
            return 3;
        case 12:
            return 5;
        default:
            0;
    }
}