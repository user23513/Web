// for_loop2.js

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

let ary = JSON.parse(data);

// forEach : return값이 없음
ary.forEach(obj => {
    if (obj.gender == 'Female') {
        console.log(obj);
    }
});

let femaleAry = ary.filter(obj => obj.gender == 'Female');

console.clear();
let newCompany = ary.map(obj => {
        let newElem = {}; //A'
        newElem.nId = obj.id;
        newElem.name = obj.first_name + ',' + obj.last_name;
        newElem.salary = obj.salary * 1.5;
        newElem.isNew = obj.salary > 4000 ? false : true;
        return newElem;
    }) // A -> A'
    .filter(obj => obj.isNew);

console.log(newCompany);

let result = newCompany.reduce((accum, curr, curIdx) => {
    if (curIdx == newCompany.length - 1) {
        return (accum + curr.salary) / newCompany.length;
    }
    return accum + curr.salary;
}, 0); // 새로운회사 직원 급여 합/평균

console.log(result);

