<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<h2 align="center">这是主页，index.jsp</h2><br>

<!-- 静态包含用户信息页面 -->
<%@ include file="/loginInfo.jsp"%>
<br>
<br>

<div align="center"><a href="<%=contextPath%>/items/queryItems.do">查看商品列表</a></div><br>
<div align="center"><a href="<%=contextPath%>/items/bindParamMap.do">测试Map类型的参数绑定</a></div><br>
<font color="red">其他属性测试：</font><br>
上下文路径contextpath:<%=contextPath %><br>
测试模型属性modelAttribute:${testModelAttribute}<br>
ContextPath:${request.ContextPath }<br>

</body>
</html>