//object_class.js

class Estimate {
    constructor(param) {
        this.unit = param; //{unit:param}
    }
    //견적가 얻기 메서드
    getEstimate(unittype, width, height) {
        let priceinfo = this.unit.find(item => item.type == unittype);
        return priceinfo.price * width * height;
    }
    //배열에 요소 추가 메서드
    addUnit(unit) {
        this.unit.push(unit); // 
    }
}

let unitinfo = [{
        type: 'wood',
        price: 100
    },
    {
        type: 'iron',
        price: 300
    },
    {
        type: 'plast',
        price: 200
    }
];
const estimator = new Estimate(unitinfo);
let result = estimator.getEstimate('wood', 20, 30);
estimator.addUnit({
    type: 'a',
    price: 400
});
console.log(unitinfo);
result = estimator.getEstimate('a', 20, 40);
console.log(result);

// object 타입으로 기능
let obj = {};
obj.unit = unitinfo;
obj.getEstimate = function (unittype, width, height) {
    let priceinfo = this.unit.find(item => item.type == unittype);
    return priceinfo.price * width * height;
}
obj.addUnit = function (unit) {
    this.unit.push(unit);
}
let result2 = obj.getEstimate('wood', 20, 20);
console.log(result2);