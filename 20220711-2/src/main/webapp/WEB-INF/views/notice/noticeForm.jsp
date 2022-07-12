<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeForm.jsp</title>
</head>
<body>
	<div align="center">
		<div><h1>게시글 등록</h1></div>
		<div>
			<form id="frm" action="noticeInsert.do" method="post" enctype="multipart/form-data"> <!-- 첨부파일 있을때는 반드시 enctype="multipart/form-data"넣어줘야함 -->
				<div>
					<table border="1">
						<tr>
							<th width="150">작성자</th>
							<td width="200">
								<input type="text" id="noticeWriter" name="noticeWriter"> <!-- id(자바스크립트네서 사용)와 name(자바에서 사용)을 반드시 쓴다. -->
							</td>
							<th width="150">작성일자</th>
							<td width="200">
								<input type="date" id="noticeDate" name="noticeDate">
							</td>
						</tr>
						<tr>
							<th>제목</th> <!-- 첫번째 th의 width를 따라감 -->
							<td colspan="3">
								<input size="73" type="text" id="noticeTitle" name="noticeTitle">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">
								<textarea rows="6" cols="75" id="noticeSubject" name="noticeSubject"></textarea>
							</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3">
								<input type="file" id="file" name="file"> <!-- file객체 -->
							</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="저장">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>