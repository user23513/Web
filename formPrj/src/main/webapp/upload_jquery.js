/**
 * upload_jquery.js
 * Ajax => XMLHttpRequest, fetch, $.ajax()
 */

//	서버에서 데이터를 가져오게 해주는게 서블릿
$(document).ready(function(){
	
	// 페이지 리스트 출력
	 $.ajax({
		url: 'member',
		method: 'get', // default: get방식
		data: 'cmd=list',
		success: showList,
		error: function(err){
			console.log(err);
		}
	});
	
	// 추가버튼 클릭.
	$('form[name="memberFrm"]').on('submit', memberAddCallBack);
	
});

function memberAddCallBack(e) {
	e.preventDefault();
	console.log(e.target); // form태그
	let fData = new FormData(e.target); // FormData에 매개값으로 form을 넣어주면 input값을 다 담고있음
	for(let d of fData.entries()){
		console.log(d)
	}
	// ajax 호출 => 데이터 등록, 화면에도 추가
	$.ajax({
		url: 'memberUpload',
		method: 'post',
		data: fData,
		contentType: false, // FormData일때 이거(contentType, processData) 설정해줘야함
		processData: false,
		dataType: 'json', // 결과값을 json 형식으로 변경.
		success: function(result) {
			console.log(makeTr(result))
			let tbody = $('#show > table > tbody');
			tbody.append(makeTr(result));
			
		},
		error: function(err) {
			console.log(err);
		}
	});
}

function showList(result) {
	console.log(result);
	let tbody = $('#show > table > tbody');
	$(result).each((idx, elem) => {
		tbody.append(makeTr(elem));
	});
	
}

function makeTr(elem) {
	let btn = $('<button />').text('삭제');
		btn.on('click', removeCallBack); // 이벤트 등록 / 이벤트는 매개값으로 무조건 event가 넘어감

	// 자바스크립트에서 값이 있으면 true / null, '', 0, undefined => false
	let imgSrc = elem.membImage ? '<img width="50px" src="images/'+elem.membImage+'"></img>' : 'no img'; 

	return $('<tr />').attr('id', elem.membNo)
					  .append($('<td />').text(elem.membNo)
							,$('<td />').text(elem.membName)
							,$('<td />').text(elem.membPhone)
							,$('<td />').text(elem.membAddr)
							,$('<td />').text(elem.membBirth)
							,$('<td />').html(imgSrc)
							,$('<td />').append(btn)
							,$('<td />').append($('<input />').attr('type', 'checkbox'))
						  )
								  

								  
}

function removeCallBack(e){
		// 비동기 호출.
		let membNo = $(e.target).parent().parent().attr('id');
			$.ajax({
				url: 'member',
				method: 'post',
				data: 'cmd=remove&delNo=' + membNo,
				success: function(result){
					if(result.retCode == 'Success'){
						$('#'+membNo).remove();
					}else{
						alert('처리중 에러');
					}
				},
				error: function(err){
					console.log(err);
				}
			})

}