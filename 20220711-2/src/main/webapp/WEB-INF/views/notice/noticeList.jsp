<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script> <!-- 제이쿼리 라이브러리 쓰겠다. -->
</head>
<body>
	<div align="center">
		<div>게시글목록</div>
		<div>
			<form id="frm">
				<select id="key" name="key" >
					<option value="notice_title">제목</option>
					<option value="notice_subject">내용</option>
					<option value="notice_writer">작성자</option>
				</select>&nbsp;
				<input type="text" id="val" name="val">&nbsp;&nbsp;
				<input type="button" value="검색" onclick="noticeSearch()">
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="70">순번</th>
						<th width="130">작성자</th>
						<th width="200">제목</th>
						<th width="130">작성일자</th>
						<th width="180">첨부파일</th>
						<th width="70">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list }">
							<c:forEach items="${list }" var="b">
								<tr>
									<td>${b.noticeId }</td>
									<td>${b.noticeWriter }</td>
									<td>${b.noticeTitle }</td>
									<td>${b.noticeDate }</td>
									<td>${b.noticeAttech }</td>
									<td>${b.noticeHit }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6" align="center">게시글이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div><br>
		<div>
			<c:if test="${author == 'ADMIN' }">
				<button type="button" onclick="location.href='noticeForm.do'">글등록</button>
			</c:if>
		</div>
	</div>
	
	<script> 
		function noticeSearch() {
			let key = $("#key").val();
			let val = $("#val").val();
			//ajax function Call
			$.ajax({
				url:"ajaxNoticeSearch.do",
				type:"post",
				data:{
					"key" : key,
					"val" : val
				},
				dataType:"json",
				success : function(result) {
					console.log(result);
				},
				error : function(error) {
					console.log(error);
				}
			})
		}
	</script>
</body>
</html>