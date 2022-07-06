<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el.jsp</title>
</head>
<body>
<ul>
<%-- <%= %>이거와 ${}이게 같다. --%>
	<li> ${param.name}  <%--<%= request.getParameter("name") %> --%>
	<li> ${id}			<%-- <%= request.getAttribute("id")%> --%>
	<li> ${pageContext.request.method}
	<li> ${pageContext.request.getMethod()} <%-- <%= request.getMethod() %> --%>
	<li> ${arr[0]} ${arr[1]} <!-- 배열이면 알아서 형변환 시켜줌 -->
	
</ul>

</body>
</html>