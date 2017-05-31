<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
</head>
<body>

<center>
<form action="<%=request.getContextPath() %>/teacher_queryListByPage.do" method="post">
	<input type="text" name="condition"><input type="submit" value="查询">
</form>
</center>

<a href="<%=request.getContextPath() %>/teacher_download.do" style="float: right;">报表导出</a>
	<table border="1" width="800px" align="center">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>状态</th>
			<th>查看</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${pageUtil.list}" var="tea" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${tea.tName}</td>
				<td>${tea.tSex.dValue}</td>
				<td>${tea.tState.dValue}</td>
				<td><a href="<%=request.getContextPath() %>/teacher_queryOne.do?teacher.tId=${tea.tId}">详细信息</a></td>
				<td><a href="<%=request.getContextPath() %>/teacher_delete.do?teacher.tId=${tea.tId}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<jsp:include page="/view/uitlpage/pageutil.jsp"></jsp:include>
		</tr>
	</table>
	
	<a href="<%=request.getContextPath() %>/view/teacher/add.jsp">添加</a>
	<script type="text/javascript">
		function jumpPage(pageNum){
			
			if(!isNaN(pageNum)){
				if(pageNum<=0 || pageNum > ${pageUtil.totalPage}){
					alert("您所查找页面超出范围！！请查找正确范围");
				}else{
					window.location = "<%=request.getContextPath()%>/teacher_queryListByPage.do?curPage="+pageNum;
				}
			}else{
				alert("您所提交的不是一个数字，看是否多了空格等字符！！！")
			}
		}
	</script>
	
</body>
</html>