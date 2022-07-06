<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsert.jsp</title>
</head>
<body>
	<div>
		<h2>게시물 등록</h2>
		<form action="boardInsert" method="post">
			<label for="id">게시번호</label>
			<input type="text" name="id" value="" readonly><br>
			
			<label for="title">제목</label>
			<input type="text" name="title" value=""><br>
			
			<label for="content">내용</label>
			<input type="text" name="content" value=""><br>
			
			<label for="writer">작성자</label>
			<input type="text" name="writer" value=""><br>
			
			<label for="rdt">날짜</label>
			<input type="date" name="rdt" value=""><br>
			
			<label for="hit">조회수</label>
			<input type="number" name="hit" value=""><br>
			
			<input type="submit" value="등록">
			
		</form>
	</div>

</body>
</html>