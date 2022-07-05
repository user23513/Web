<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="co.micol.prj.emp.JobsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>empUpdate.jsp</title>
	<style>
		body {
			margin: 0;
		}
		div {
			width: 1000px;
			margin-left: auto;
			margin-right: auto;
		}
		form {
			padding-left: 55px;
		}
		label {
			display: inline-block;
			width: 200px;
			background-color: lavender;
			text-align: center;

		}
		input[type="submit"] {
			margin-top: 7px;
		}
	</style>
	<script>
		function validateForm() {
			if(frm.employeeId.value == "") {
				alert("사원번호를 입력하세요");
				frm.employeeId.focus();
				return false;
			}
			if(frm.lastName.value == "") {
				alert("이름을 입력하세요");
				frm.lastName.focus();
				return false;
			}
			if(frm.email.value == "") {
				alert("이메일을 입력하세요");
				frm.email.focus();
				return false;
			}
			var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			if(regExp.test(frm.email.value) == false) {
				alert("이메일형식이 안맞습니다");
				frm.email.focus();
				return false;
			}
			if(frm.hireDate.value == "") {
				alert("입사년도를 입력하세요");
				frm.hireDate.focus();
				return false;
			}
			if(frm.jobID.value == "") {
				alert("부서명을 입력하세요");
				frm.jobID.focus();
				return false;
			}
			return true;
		}
	</script>
</head>

<body>
	<div>
		<h2 style="text-align: center;">사원수정</h2>
		<form name="frm" action="empInsert" method="post" onsubmit="return validateForm()">
			<label for="employeeId">사원번호</label>
			<input type="number" name="employeeId"><br>

			<label for="lastName">이름</label>
			<input type="text" name="lastName"><br>

			<label for="email">이메일</label>
			<input type="text" name="email"><br>

			<label for="hireDate">입사년도</label>
			<input type="date" name="hireDate"><br>

			<label for="jobID">직무</label>
			<select name="jobID">
				<% 	List<JobsVO> list = (List<JobsVO>)request.getAttribute("dept");
					for(JobsVO jobs : list) { %>
					<option value="<%= jobs.getJobId() %>"><%= jobs.getJobTitle() %>
				<% } %>
			</select><br>
			<label for="deptId">부서명</label>
			<% List<DeptVO> deptlist = (List<DeptVO>)request.getAttribute("depts"); 
			   for(DeptVO dept : deptlist) { %>
				<input type="radio" name="deptId" value="<%= dept.getDeptId() %>"><%= dept.getDeptName()%>
			<% } %>
			<input type="submit" value="저장">
		</form>
	</div>
</body>

</html>