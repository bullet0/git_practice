<!DOCTYPE html>

<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<c:url context="<%=request.getContextPath() %>" value="/teacher_queryListByPage.do?condition=" var="messageUrl" />
		<a href="${messageUrl}">Click to enter查询全部</a>
		<a href="<%=request.getContextPath() %>/teacher_queryOne.do">Click to enter查询一条</a>
		<a href="<%=request.getContextPath() %>/teacher_test.do?tId=666&teacher.tName=456">cesiistu</a>
		
		<%
			ApplicationContext cxt = WebApplicationContextUtils.getWebApplicationContext(application);
		
		%>
		<%=cxt.getBean("teacherService") %>
	</body>
</html>
