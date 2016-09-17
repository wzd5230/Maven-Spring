<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bindParamMap.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<h3 style="color: red;">已接收参数显示：</h3><br>
		<c:forEach items="${itemsQueryVo.mapValue }" var="item">
			key:${item.key}<br>
			value:${item.value}<br>
		</c:forEach>
	<br>
	<h3 style="color: red;">传递新参数：</h3><br>
	<form name="MapParam" method="post">
		key-value:<input type="text" name="mapValue['wzdKey']"><br>
		<input type="button" value="提交" onclick="submitMap()">
	</form>
	
	<script type="text/javascript">
		function submitMap(){
			document.MapParam.action = "<%=request.getContextPath()%>/items/bindParamMap.do"; 
			document.MapParam.submit();
		}
	
	</script>	
  </body>
</html>
