<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!-- 用户登录信息的显示 -->
<c:if test="${loginUsername==null }">
尚未登陆，请<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
</c:if>
<c:if test="${loginUsername!=null }">
${loginUsername }，<a href="${pageContext.request.contextPath }/logout.do">退出</a>
</c:if>
