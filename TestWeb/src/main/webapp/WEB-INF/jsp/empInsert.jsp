<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>empInsert.jsp</title>
	<style>
		body {
			margin: 0;
		}
		div {
			width: 500px;
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
</head>

<body>
	<div>
		<h2 style="text-align: center;">사원등록</h2>
		<form action="">
			<label for="empId">사원번호</label>
			<input type="number" name="empId"><br>

			<label for="empLastName">이름</label>
			<input type="text" name="empLastName"><br>

			<label for="empEmail">이메일</label>
			<input type="text" name="empEmail"><br>

			<label for="empHireDate">입사년도</label>
			<input type="date" name="empHireDate"><br>

			<label for="empJobId">부서명</label>
			<input type="text" name="empJobId"><br>

			<input type="submit" value="저장">
		</form>
	</div>
</body>

</html>