<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="cn.wzd.ssm.po.ItemsCustom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 静态包含用户信息页面 -->
<%@ include file="/loginInfo.jsp"%>
<br>


<h1 align="center">商品列表显示</h1><br>

<%
	List<ItemsCustom> itemsList = (List<ItemsCustom>)request.getAttribute("itemsList");
	Iterator<ItemsCustom> iterator = itemsList.iterator();
%>

<form name="ItemsEdit" action="" method="post">
	<table border="1" align="center">
		<tr>
			<td align="center" width="150">
				批量/修改删除
			</td>
			<td align="center" width="150">
				商品id
			</td>
			<td align="center" width="150">
				商品名称
			</td>
			<td align="center" width="150">
				商品价格
			</td>
			<td align="center" width="150">
				商品详细
			</td>
			<td align="center" width="150">
				商品图片
			</td>
			<td align="center" width="150">
				创建时间
			</td>
			<td align="center" width="150">
				修改信息
			</td>					
		</tr>
		
<% 
	while(iterator.hasNext()){
		ItemsCustom itemsCustom = iterator.next();
%>
		<tr>
			<td align="center" width="150">
				<input type="checkbox" name="multiEditIds" value="<%=itemsCustom.getId() %>"><%=itemsCustom.getId() %>
			</td>
			<td align="center" width="150">
				<%=itemsCustom.getId() %>
			</td>
			<td align="center" width="150">
				<%=itemsCustom.getName() %>
			</td>
			<td align="center" width="150">
				<%=itemsCustom.getPrice() %>
			</td>
			<td align="center" width="150">
				<%=itemsCustom.getDetail() %>
			</td>
			<td align="center" width="150">
				<%=itemsCustom.getPic() %>
			</td>
			<td align="center" width="150">
				<%=itemsCustom.getCreatetime() %>
			</td>
			<td align="center" width="150">
				<%--get方式传递参数id --%>
				<a href="<%=request.getContextPath()%>/items/editItem.do?id=<%=itemsCustom.getId()%>">修改</a>
			</td>					
		</tr>
<%
	}
%>
	<tr>
		<td>
			<input type="button" value="批量删除" onclick="multiRemove()"/>
			<input type="button" value="批量修改" onclick="multiEdit()"/>
		</td>
	</tr>
	</table>
</form><br/>

测试model modelandview request session属性使用优先级:${testAttribute}
测试模型属性modelAttribute:${testModelAttribute}


<script type="text/javascript">
	function multiEdit(){
		document.ItemsEdit.action="<%=request.getContextPath()%>/items/multiEditItems.do";
		document.ItemsEdit.submit();
	}
	
	function multiRemove(){
		document.ItemsEdit.action="<%=request.getContextPath()%>/items/deleteItems.do";
		document.ItemsEdit.submit();
	}

</script>


</body>
</html>