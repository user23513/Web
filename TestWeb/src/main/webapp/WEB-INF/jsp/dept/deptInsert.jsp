<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptInsert.jsp</title>
<script>
	function validationForm() {
		if(frm.deptId.value == "") {
			alert("부서번호 입력하세요");
			return;
		}
		
		frm.submit(); //폼 전송(submit버튼클릭과 같다)
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<form name="frm" action="DeptInsert" method="post">
		부서번호<input type="number" name="deptId"><br>
		부서명<input type="text" name="deptName"><br>
		매니저번호<input type="number" name="deptManagerId"><br>
		지역번호<input type="number" name="deptLocationId"><br>
		
		<button type="button" onclick="validationForm()">부서등록</button>
	</form>

</body>
</html>