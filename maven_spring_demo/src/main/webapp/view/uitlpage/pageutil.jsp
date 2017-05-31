<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<td colspan="20" align="center">
共${pageUtil.totalCount}条/共${pageUtil.totalPage}页/第${pageUtil.curPage}页
	<a href="javascript:void(0)" onclick="jumpPage(1)">首页</a> 
	<a href="javascript:void(0)" onclick="jumpPage('${pageUtil.curPage - 1}')">上一页</a> 
	<a href="javascript:void(0)" onclick="jumpPage('${pageUtil.curPage + 1}')">下一页</a> 
	<a href="javascript:void(0)" onclick="jumpPage('${pageUtil.totalPage}')">尾页</a> 
	<input type="text" style="width: 50px"/><button onclick="jumpPage($(this).prev().val())">跳转</button> 
</td>

</body>
</html>