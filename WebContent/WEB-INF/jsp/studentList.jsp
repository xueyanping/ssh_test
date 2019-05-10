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
			<tr>
				<td>${s.name}</td>
				<td>${s.sex}</td>
				<td>${s.age}</td>
				<td>${s.teacher.name}</td>
				<td>${s.teacher.tCourse}</td>
			</tr>
		</thead>
	</table>
	studentList!!!
	
</body>
</html>