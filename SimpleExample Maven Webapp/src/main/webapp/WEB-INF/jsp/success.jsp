<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息修改成功</title>
</head>
<body>
	<!-- 静态包含用户信息页面 -->
	<%@ include file="/loginInfo.jsp"%>
	<br>

	信息修改成功！！<br>
	修改信息：${success_msg}
</body>
</html>