<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js" type="text/javascript"></script>
<title>index</title>
<script type="text/javascript">
	$(function(){
		
	});
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/demo_index.action" method="post">
	name:<input type="text" name="name">
	sex:<input type="text" name="sex">
	<input type="submit" value="提交">
</form>
</body>
</html>