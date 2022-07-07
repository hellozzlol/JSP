
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<title>사원목록</title>
<h1>사원목록</h1>
<a href="/TestWeb/empInsert">사원등록</a><br>

<form>
<input name="departmentId">

<button>검색</button>

</form>
</head>
<style>
th, td {
	border: 1px solid #000000;
	border-color: #bebebe;
	width: auto;
	padding: 5px;
	margin: auto;
	text-align: center;
}


</style>
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
					<td><a href="empUpdate?employeeId=${vo.employeeId}">${vo.lastname}</a></td>
					<td>${vo.email}</td>
					<td>${vo.hiredate}</td>
				</tr>
			</c:forEach>

		</tbody> 
	</table>
</body>
</html>