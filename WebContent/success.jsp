<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js" type="text/javascript"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		/* $("p").click(function(){
			$.post("${pageContext.request.contextPath}/demo_list.action","",function(data){
				
			});
		}); */
	});
</script>
</head>
<body>
success!!
<p>name:${student.name}</p>
<p>sex:${student.sex}</p>
<a href="${pageContext.request.contextPath}/demo_list.action">跳转</a>	

</body>
</html>