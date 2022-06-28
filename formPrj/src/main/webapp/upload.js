/**
 * upload.js
 */

document.addEventListener('DOMContentLoaded', function() { // document object가 모두 로딩된다음에 이코드를 실행시키시오. (body까지 다 읽어들인 다음에)
	let tbl = document.querySelector('#show table');
	let capt = document.createElement('caption');
	capt.innerHTML = '회원리스트';
	tbl.append(capt);

	// 리스트 출력
	let ajax = new XMLHttpRequest();
	ajax.open('get', 'member?cmd=list');
	ajax.send();
	ajax.onload = function() {
		let data = JSON.parse(this.responseText); // 여기서 this는 xhtp
		console.log(data);

		let tbody = document.querySelector('#show tbody'); // ajax호출이기 때문에 가지고 오기 전에 코드가 다 로딩이 되었기 때문에 여기 안에 안들어있어도 가능
		data.forEach(member => {
			tbody.append(makeTr(member));
		})
	}

	// form 기본 기능 X => ajax로 처리 (XMLHttpRequest, fetch)
	document.forms.memberFrm.addEventListener("submit", function(e) {
		e.preventDefault(); // 기본기능을 차단하겠습니다.

		let formData = new FormData(e.target); // e.target = form
		
		for (let ent of formData.entries()) { // form안에 key와 value값을 배열형식으로 다 가져옴
			console.log(ent);
		};
		
		
		// get: url, post: 추가정보지정.
		fetch('memberUpload', {
			method: 'post',
			body: formData
		})
			.then(function(result) {
				return result.json();
			})
			.then(function(result) {
				console.log(result);
				
				document.querySelector('#show tbody').append(makeTr(result));
			})
			.catch(function(err) {
				console.error(err);
			})

	})


});





let fields = ['membNo', 'membName', 'membPhone', 'membAddr', 'membBirth', 'membImage']

// 회원정보 => tr 생성.
function makeTr(member) { // 호출할때 실행되니깐 어디있어도 상관없음.
	//console.log(member)
	let tr = document.createElement('tr');
	tr.setAttribute('id', member.membNo); // tr의 attribute중에 id를 활용

	fields.forEach(field => {
		//console.log(member[field])
		let td = document.createElement('td');
		// null, 0, undefined, '' => false 이외 true;
		//td.innerHTML = member[field] ? member[field] : (!'' ? field == 'membImag' ? 'no img' : '' : '');
		td.innerHTML = member[field] ? (field == 'membImage' ? '<img width="60px" src="images/' + member[field] + '">' : member[field]) : '';
		//td.innerHTML = member[field] ? (field == 'membImag' ? member[field]:member[field]):'';

		tr.append(td);
	})

	// 삭제버튼
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.addEventListener('click', rowDelete, false);
	let td = document.createElement('td');
	td.append(btn);
	tr.append(td);

	// 체크박스. input type='checkbox'
	td = document.createElement('td');
	let ckBox = document.createElement('input');
	ckBox.setAttribute('type', 'checkbox');
	td.append(ckBox);
	tr.append(td);

	return tr;
}


function rowDelete() {
	let delId = this.parentElement.parentElement.getAttribute('id'); 
//	let formData = new FormData();
//	formData.append("cmd", "delete");
//	formData.append("delId", delId);


	fetch('memberUpload', {
		method: 'post',
		headers: {
			'Content-type': 'application/x-www-form-urlencoded'
		},  // id=32&name=hong... 이런식의 형식 
		body: `cmd=delete&delId=${delId}`
	})
		.then(function(result){
			return result.json();
		})
		.then(function(result){
			//화면에서 삭제
			document.getElementById(delId).remove();
			console.log(result);
		})
		.catch(function(err){
			console.error(err);
		})
		
	

}




