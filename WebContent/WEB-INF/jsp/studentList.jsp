<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentList</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>教师</th>
				<th>学科</th>
			</tr>
			<%-- <tr>
				<td>${s.name}</td>
				<td>${s.sex}</td>
				<td>${s.age}</td>
				<td>${s.teacher.name}</td>
				<td>${s.teacher.tCourse}</td>
			</tr> --%>
		</thead>
	</table>
	studentList!!!<br/>
	笔记(word文档doc格式)<a href="${pageContext.request.contextPath }/demo_doDownload.action?filename=8763b5302c77482ab5775e72fb72e8ca.docx">下载</a><br/>
	mp4<a href="${pageContext.request.contextPath }/demo_doDownload.action?filename=9bf5248d4ac84a9885ebd298fe35b508.mp4">下载</a><br/>
	pdf<a href="${pageContext.request.contextPath }/demo_doDownload.action?filename=3f2d16e1198243659315519609ffa08f.pdf">下载</a><br/>
	txt <a href="${pageContext.request.contextPath }/demo_doDownload.action?filename=2ad02cbbefb8437aa2510e7c4ab6b1fd.txt">下载</a><br/>
	
	</body>
</html>