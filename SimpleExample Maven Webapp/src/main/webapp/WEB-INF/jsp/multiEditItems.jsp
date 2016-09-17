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
    
    <title>My JSP 'multiEditItems.jsp' starting page</title>
    
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
  
<!-- 静态包含用户信息页面 -->
<%@ include file="/loginInfo.jsp"%>
<br>
  
  <h1 align="center">多商品信息修改</h1><br>
  
  <form action="<%=request.getContextPath()%>/items/updateMultiItems.do" method="post">
  <table align="center" border="1" width="80%">
  
  	<tr>
  		<td align="center">
			商品id			  		
  		</td>
  		<td align="center">
			商品名称
  		</td>
  		<td align="center">
			商品价格
  		</td>
  		<td align="center">
			商品详细
  		</td>
  		<td align="center">
			商品图片
  		</td>
  		<td align="center">
			商品创建时间<br>
			(格式：1999-12-31 12:25:25)
  		</td>
  	</tr>
  	
	<c:forEach items="${itemsCustoms}" var="item" varStatus="status">
		<tr>
			<td align="center">
				${item.id}<input type="hidden" name="editItemsCustoms[${status.index}].id" value="${item.id}">
			</td>
			<td align="center">
				<input type="text" name="editItemsCustoms[${status.index}].name" value="${item.name}">
			</td>
			<td align="center">
				<input type="text" name="editItemsCustoms[${status.index}].price" value="${item.price}">
			</td>
			<td align="center">
				<input type="text" name="editItemsCustoms[${status.index}].detail" value="${item.detail}">
			</td>
			<td align="center">
				<input type="text" name="editItemsCustoms[${status.index}].pic" value="${item.pic}">
			</td>
			<td align="center">
				<input type="text" name="editItemsCustoms[${status.index}].createtime" value="${item.createtime}">
			</td>
		</tr>
	</c:forEach>
  
  <tr>
  	<td>
  		<input type="submit" value="提交修改">
  	</td>
  </tr>
  
  </table>
  </form>
  
  
  
  
  
    
  </body>
</html>
