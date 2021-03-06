// arrry_basic3.js

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

let genderInput = prompt('Male of Female을 입력');

let objAry = JSON.parse(data);

// 표(table) 형태로 출력.
let result = objAry.filter((val => val.gender == genderInput))
    .reduce((accum, curr, curIdx, ary) => {
        let str = '';
        if (curIdx == 0) {
            str += `<table border=1>`
        }
        str += `<tr>`;
        for (let val in curr) {
            str += `<td>${curr[val]}</td>`;
        }
        str += `</tr>`;
        if (curIdx == ary.length - 1) {
            str += `</table>`
        }
        return accum + str;

    }, '');

// let result = objAry.reduce((accum, curr, curIdx) => {
//     if (curIdx == 0) {
//         accum += `<table border=1>`;
//     }
//     if(curr.gender == genderInput){
//         accum += `<tr>`;
//         for (let key in curr) {
//             accum += `<td>${curr[key]}</td>`;
//         }
//         accum += '</tr>';
//     }
//     if(curIdx == objAry.length-1) {
//         accum += `</table>`;
//     }
//     return accum;
// }, '');

document.write(result);