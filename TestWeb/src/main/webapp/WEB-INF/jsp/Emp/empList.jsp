
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>
<h1>사원목록</h1>
<a href="/TestWeb/empInsert">사원등록</a><br>

<form>
<input name="departmentId">

<button>검색</button>

</form>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>사원번호</th>
				<th>사원이름</th>
				<th>이메일</th>
				<th>입사일</th>
			</tr>
		</thead>
		 <tbody>
			<c:forEach var="vo" items="${list}"> 
				<tr>
					<td>${vo.employeeId}</td>
					<td>${vo.lastname}</td>
					<td>${vo.email}</td>
					<td>${vo.hiredate}</td>
				</tr>
			</c:forEach>

		</tbody> 
	</table>
</body>
</html>