<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsert.jsp</title>
</head>
<body>
	<div>
		<h2>게시물 수정 및 삭제</h2>
		<form action="boardInsert" method="post">
			<label for="id">게시번호</label>
			<input type="text" name="id" value="${vo.id}" readonly><br>
			
			<label for="title">제목</label>
			<input type="text" name="title" value="${vo.title}"><br>
			
			<label for="content">내용</label>
			<input type="text" name="content" value="${vo.content}"><br>
			
			<label for="writer">작성자</label>
			<input type="text" name="writer" value="${vo.writer}"><br>
			
			<c:set var="date" value="${vo.rdt}"></c:set>
<%-- 			${fn:substring(자를 문자열, 시작 위치, 끝 위치) }  --%>
			<label for="rdt">날짜</label>
			<input type="date" name="rdt" value="${fn:substring(date,0,10)}"><br>
			
			<label for="hit">조회수</label>
			<input type="number" name="hit" value="${vo.hit}"><br>
			
			<input type="submit" value="수정">
			
			
		</form>
	</div>

</body>
</html>