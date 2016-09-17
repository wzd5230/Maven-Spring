<%@page import="cn.wzd.ssm.po.ItemsCustom"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息修改</title>
</head>
<body>

<!-- 静态包含用户信息页面 -->
<%@ include file="/loginInfo.jsp"%>
<br>

<h1 align="center">商品信息修改</h1><br>


<%-- 在页面顶端集中显示错误信息 --%>
<c:if test="${errorMessage!=null}">
	<font color="red">表单错误信息集中显示：</font><br>
	<c:forEach items="${errorMessage}" var="item">
		${item.key }&nbsp;---->&nbsp;${item.value }<br>
	</c:forEach>
</c:if>


<form action="<%=request.getContextPath()%>/items/updateItems.do" method="post" enctype="multipart/form-data">
	<table align="left" border="1" width="80%">
		<tr>
			<td align="center" width="200">
				项目
			</td>
			<td align="center">
				信息
			</td>
		</tr>
		<tr>
			<td align="center">
				商品id(不可修改)
			</td>
			<td align="left">
				${itemsCustom.id }
			</td>
		</tr>
		<tr>
			<td align="center">
				商品名称
			</td>
			<td align="left">
				<input type="text" name="name" value="${itemsCustom.name }">
				<c:if test="${errorMessage.get(\"name\")!=null }">
					<font color="red">${errorMessage.get("name")}</font>
				</c:if>
			</td>
		</tr>
		<tr>
			<td align="center">
				商品价格
			</td>
			<td align="left">
				<input type="text" name="price" value="${itemsCustom.price }">
			</td>
		</tr>
		<tr>
			<td align="center">
				商品详细
			</td>
			<td align="left">
				<input type="text" name="detail" value="${itemsCustom.detail }">
				<c:if test="${errorMessage.get(\"detail\")!=null }">
					<font color="red">${errorMessage.get("detail")}</font>
				</c:if>
			</td>
		</tr>
		<tr>
			<td align="center">
				商品图片
			</td>
			<td align="left">
				<c:if test="${itemsCustom.pic!=null }">
				<img alt="商品图片" src="/picture/${itemsCustom.pic}">
				</c:if>
				<input type="file" name="itemPicture" align="right">
				<input type="hidden" name="pic" value="${itemsCustom.pic}">
			</td>
		</tr>
		<tr>
			<td align="center">
				商品创建时间<br>
				(格式:1999-12-20 18:59:59)
			</td>
			<td align="left">
				<input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
				
				<c:if test="${errorMessage.get(\"createtime\")!=null }">
					<font color="red">${errorMessage.get("createtime")}</font>
				</c:if>
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="提交修改">
				<%-- 表单携带隐藏信息，需要编辑的商品的id --%>
				<input type="hidden" name="id" value="${itemsCustom.id }">				
			</td>
		</tr>
	</table>
</form><br/>



</body>
</html>