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

<h1 align="center">商品列表显示</h1><br>

<%
	List<ItemsCustom> itemsList = (List<ItemsCustom>)request.getAttribute("itemsList");
	Iterator<ItemsCustom> iterator = itemsList.iterator();
%>
	<table border="1" align="center">
		<tr>
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
		</tr>
		
<% 
	while(iterator.hasNext()){
		ItemsCustom itemsCustom = iterator.next();
%>
		<tr>
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
		</tr>
<%
	}
%>
		
	</table>



</body>
</html>