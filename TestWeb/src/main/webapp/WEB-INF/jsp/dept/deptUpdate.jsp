<%@page import="co.micol.prj.dept.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptInsert.jsp</title>
<script>
	function validationForm() {
		if(frm.deptName.value == "") {
			alert("부서명을 입력하세요");
			return;
		}
		
		frm.submit(); //폼 전송(submit버튼클릭과 같다)
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<% DeptVO dept = (DeptVO)request.getAttribute("dept"); %>
	<form name="frm" action="DeptUpdate" method="post">
		부서번호<input type="text" name="deptId" value="<%= dept.getDeptId()%>" readonly><br>
		부서명<input typr="text" name="deptName" value="<%= dept.getDeptName()%>"><br>
		매니저번호<input type="number" name="deptManagerId" value="<%= dept.getDeptManagerId()%>"><br>
		지역번호<input type="number" name="deptLocationId" value="<%= dept.getDeptLocationId()%>"><br>
		
		<button type="button" onclick="validationForm()">부서수정</button>
	</form>

</body>
</html>