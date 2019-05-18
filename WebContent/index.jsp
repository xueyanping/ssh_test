<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js" type="text/javascript"></script>
<title>index</title>

</head>
<body>
<form action="${pageContext.request.contextPath }/demo_index.action" method="post" enctype="multipart/form-data">
	name:<input type="text" name="name">
	sex:<input type="text" name="sex">
	 上传文件1：<input type="file" name="upload">
	 上传文件2：<input type="file" name="upload">
	 上传文件3：<input type="file" name="upload">
	 上传文件4：<input type="file" name="upload">
	 上传文件5：<input type="file" name="upload">
	<input type="submit" value="提交">
</form>
</body>
</html>