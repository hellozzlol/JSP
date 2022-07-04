<%@page import="co.micol.prj.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>
<h3>사원목록</h3>
<a href="http://localhost/TestWeb/empInsert">사원등록</a>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>급여</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}"> <%--for(EmpVO vo : list) 주석처리 for(i=0;i<10); --%>
				<tr>
					<td>${vo.employeeId}</td>
					<td>${vo.firstname}</td>
					<td>${vo.salary}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>