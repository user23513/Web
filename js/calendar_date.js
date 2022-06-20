// calendar_date.js

let today = new Date('2022-06'); // 매개값 아무것도 안넣으면 현재날짜
today = new Date(2022,5,0);
console.log(`올해는 ${today.getFullYear()}년도 입니다.`);
console.log(`이번달은 ${today.getMonth()+1}월 입니다.`); // 0 ~ 11
console.log(`오늘은 ${today.getDate()}일 입니다.`);
console.log(`오늘은 ${today.getDay()}`); //요일정보 0 ~ 6

// 달력 작성. 6월 작성. 6월1일의 요일. 6월의 마지막날
let year = 2021; // 2021년
let month = 6;   // 6월달

document.write(makeCalendar(year,month));

function makeCalendar(y, m){
    // 년, 월 달력 정보 생성.
    let dayInfo = new Date(y,m-1).getDay();
    let lastDateInfo = new Date(y,m,0).getDate(); 

    let days = ['일','월','화','수','목','금','토'];
    let str = '<table border=1><caption>'+y+'년 '+m+'월</caption><tr>';

    for(let day of days){
        str += '<td>' + day + '</td>';
    }
    str += '</tr><tr>';

    for(let i = 0; i < today.getDate(); i++){
        str += '<td>'
    }

    str += '</table>'
    
    return str;
}


