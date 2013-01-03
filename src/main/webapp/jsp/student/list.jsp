<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Student管理页面</title>

<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	function update(id) {
		$.ajax({
			url : '<%=contextPath%>/student/'+id,
			type : "get",
			dataType : "json",
			cache: false,
			data : null,
			success : function(data){
				if (data) {
					$("#addForm").attr("action",'<%=contextPath%>/student/update');
					$("#addForm input[name='name']").val( data.name );
					$("#addForm select option[value='"+data.sex+"']").attr("selected",true);
					$("#addForm input[name='birthday']").val( data.birthday );
					$("#addForm input[name='id']").val( data.id );
					$("#addForm :submit").val( "修改" );
				}
			}
		});
	}
</script>
</head>

<body>
	<h1>Student管理页面</h1>
	<form id="addForm" action="<%=contextPath%>/student/add" method="post">
		<input type="hidden" name="id" />
		<input name="name" />
		<select name="sex">
			<option value="">性别</option>
			<option value="男" selected="selected">男</option>
			<option value="女">女</option>
		</select>
		<input name="birthday" />
		<input type="submit" value="新增" />
	</form>
	
	<table>
		<tr>
			<th>编号</th>
			<th>name</th>
			<th>sex</th>
			<th>birthday</th>
			<th>操作</th>
		</tr>
		<c:forEach var="student" items="${list}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${student.name}</td>
			<td>${student.sex}</td>
			<td><fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd" /></td>
			<td>
				<a href="javascript:void(0);" onclick="update(${student.id});">修改</a>
				<a href="<%=contextPath%>/student/del/${student.id}">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>