<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>这个是页面的标题</title>
</head>
<% 
	String contextPath = request.getContextPath();
%>
<body>

<h1>这是主页，index.jsp</h1><br>
contextpath:<%=contextPath %><br>
<a href="<%=contextPath%>/items/queryItems.do">查看商品列表</a>



</body>
</html>