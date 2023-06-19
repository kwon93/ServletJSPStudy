<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--jsp에서 view를 담당한다. -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	pageContext.setAttribute("result", "hello");
%>
<body>
	${requestScope.result}입니다. </br> 	<!--저장소별로 키값이 같을경우 스코프로 범위설정을 해준다.  -->
	<!-- EL: expression language  -->
	${names[0]} <br>
	${names[1]} <br>
	<br>
	${notice.title}<br>
	${result}<br>
	${not empty param.n? '값이 들어가 있습니다.': '값이 비어 있습니다.'}<br>
	${header.cookie}
</body>
</html>