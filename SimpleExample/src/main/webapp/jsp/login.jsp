<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<h1>this is login jsp file.</h1><br>

<%
	String username = "test-user-name";
	request.setAttribute("username", username);
%>


<form action="login_success.jsp" method="post">
	<input type="submit" value="测试登录成功页面">
</form>

</body>
</html>