// table.js

let data = [
    {sname:'김',age:12, height:197},
    {sname:'이',age:20, height:160}
]

class Table {
    //생성자
    constructor(ary){
        this.aryData = ary;
    }
    //메소드
    createTable(){
        this.tag = '<table border=1><tr>';
        //헤더정보 <thead>...</thead>
        for(let field in this.aryData[0]){ //{sname:'김',age:12}
            this.tag += '<th>'+field+'</th>';
        };
        this.tag += '</tr>'; 
        
        //바디정보 <tbody>...</tbody>
        this.aryData.forEach((val,idx)=>{
            // console.log(val);
            this.tag += '<tr>';
            for(let field in val) {
                this.tag += '<td>'+ val[field]+'</td>';
            }
            this.tag += '</tr>';
        });

        this.tag += '</table>';

        return this.tag;
    }
    
}

let table = new Table(data);
let str = table.createTable(); // => 표형식으로 화면출력.
console.log(str);
document.write(str);

console.log('Hongkil'.length);
let names = ['김','이이이이','박박박박'];

let searchName = names.find(function(val){
    //return val == '김'; // return해주는 값이 true이면 첫번째를 반환
    return val.length == 4;
});
console.log(searchName);



class Estimate {
    constructor(param){
        this.unit = param; //{unit:param}
    }
    //견적가 얻기 메서드
    getEstimate(unittype, width, height) {
        let priceinfo = this.unit.find(item => item.type == unittype);
        return priceinfo.price*width*height;
    }
    //배열에 요소 추가 메서드
    addUnit(unit) {
        this.unit.push(unit); // 
    }
}

let unitinfo = [
    {type:'wood',price:100},
    {type:'iron',price:300},
    {type:'plast',price:200}
];
const estimator = new Estimate(unitinfo);
let result = estimator.getEstimate('wood',20,30);
estimator.addUnit({type:'a', price:400});
console.log(unitinfo);
result = estimator.getEstimate('a',20,40);
console.log(result);

// object 타입으로 기능
let obj = {}; 
obj.unit = unitinfo;
obj.getEstimate = function(unittype,width,height){
    let priceinfo = this.unit.find(item => item.type == unittype);
    return priceinfo.price*width*height;
}
obj.addUnit = function(unit) {
    this.unit.push(unit);
}
let result2 = obj.getEstimate('wood',20,20);
console.log(result2);
