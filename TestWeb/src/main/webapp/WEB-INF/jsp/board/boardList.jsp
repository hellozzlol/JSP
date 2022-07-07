<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>
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
				<th>아이디</th>
				<th>제목</th>
				<th>글내용</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.id}</td>
					<td>${vo.title}</td>
					<td>${vo.content}</td>
					<td>${vo.writer}</td>
					<td>${vo.rdt}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>