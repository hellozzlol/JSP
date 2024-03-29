<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

html {
	font-size: 10px;
}

ul, li {
	list-style: none;
}

a {
	text-decoration: none;
	color: inherit;
}

.board_wrap {
	width: 1000px;
	margin: 100px auto;
}

.board_title {
	margin-bottom: 30px;
}

.board_title strong {
	font-size: 3rem;
}

.board_title p {
	margin-top: 5px;
	font-size: 1.4rem;
}

.bt_wrap a {
	display: inline-block;
	min-width: 80px;
	margin-left: 10px;
	padding: 10px;
	border: 1px solid #000;
	border-radius: 2px;
	font-size: 1.4rem;
}

.bt_wrap a:first-child {
	margin-left: 0;
}

.bt_wrap a.on {
	background: #000;
	color: #fff;
}

.board_list {
	width: 100%;
	border-top: 2px solid #000;
}

.board_list>div {
	border-bottom: 1px solid #ddd;
	font-size: 0;
}

.board_list>div.top {
	border-bottom: 1px solid #999;
}

.board_list>div:last-child {
	border-bottom: 1px solid #000;
}

.board_list>div>div {
	display: inline-block;
	padding: 15px 0;
	text-align: center;
	font-size: 1.4rem;
}

.board_list>div.top>div {
	font-weight: 600;
}

.board_list .num {
	width: 10%;
}

.board_list .title {
	width: 60%;
	text-align: left;
}

.board_list .top .title {
	text-align: center;
}

.board_list .writer {
	width: 10%;
}

.board_list .date {
	width: 10%;
}

.board_list .count {
	width: 10%;
}

.board_page {
	margin-top: 30px;
	text-align: center;
	font-size: 0;
}

.board_page a {
	display: inline-block;
	width: 32px;
	height: 32px;
	box-sizing: border-box;
	vertical-align: middle;
	border: 1px solid #ddd;
	border-left: 0;
	line-height: 100%;
}

.board_page a.bt {
	padding-top: 10px;
	font-size: 1.2rem;
	letter-spacing: -1px;
}

.board_page a.num {
	padding-top: 9px;
	font-size: 1.4rem;
}

.board_page a.num.on {
	border-color: #000;
	background: #000;
	color: #fff;
}

.board_page a:first-child {
	border-left: 1px solid #ddd;
}

.board_view {
	width: 100%;
	border-top: 2px solid #000;
}

.board_view .title {
	padding: 20px 15px;
	border-bottom: 1px dashed #ddd;
	font-size: 2rem;
}

.board_view .info {
	padding: 15px;
	border-bottom: 1px solid #999;
	font-size: 0;
}

.board_view .info dl {
	position: relative;
	display: inline-block;
	padding: 0 20px;
}

.board_view .info dl:first-child {
	padding-left: 0;
}

.board_view .info dl::before {
	content: "";
	position: absolute;
	top: 1px;
	left: 0;
	display: block;
	width: 1px;
	height: 13px;
	background: #ddd;
}

.board_view .info dl:first-child::before {
	display: none;
}

.board_view .info dl dt, .board_view .info dl dd {
	display: inline-block;
	font-size: 1.4rem;
}

.board_view .info dl dt {
	
}

.board_view .info dl dd {
	margin-left: 10px;
	color: #777;
}

.board_view .cont {
	padding: 15px;
	border-bottom: 1px solid #000;
	line-height: 160%;
	font-size: 1.4rem;
}

.board_write {
	border-top: 2px solid #000;
}

.board_write .title, .board_write .info {
	padding: 15px;
}

.board_write .info {
	border-top: 1px dashed #ddd;
	border-bottom: 1px solid #000;
	font-size: 0;
}

.board_write .title dl {
	font-size: 0;
}

.board_write .info dl {
	display: inline-block;
	width: 50%;
	vertical-align: middle;
}

.board_write .title dt, .board_write .title dd, .board_write .info dt,
	.board_write .info dd {
	display: inline-block;
	vertical-align: middle;
	font-size: 1.4rem;
}

.board_write .title dt, .board_write .info dt {
	width: 100px;
}

.board_write .title dd {
	width: calc(100% - 100px);
}

.board_write .title input[type="text"], .board_write .info input[type="text"],
	.board_write .info input[type="password"] {
	padding: 10px;
	box-sizing: border-box;
}

.board_write .title input[type="text"] {
	width: 80%;
}

.board_write .cont {
	border-bottom: 1px solid #000;
}

.board_write .cont textarea {
	display: block;
	width: 100%;
	height: 300px;
	padding: 15px;
	box-sizing: border-box;
	border: 0;
	resize: vertical;
}
</style>
</head>
<body>
	<div class="board_wrap">
		<div class="board_title">
			<div>
				<strong>게시글 상세보기</strong>
			</div>
			<div class="board_view_wrap">
				<div class="board_view">
					<div class="title">
						<form name="writeFrm">${noticeVo.noticeId }
							<dl>
								<dt>작성날짜</dt>
								<dd>${noticeVo.noticeDate }</dd>
							</dl>
							<dl>
								<dt>조회수</dt>
								<dd>${noticeVo.noticeHit }</dd>
							</dl>
							<dl>
								<dt>제 목</dt>
								<dd>${noticeVo.noticeTitle}</dd>
							</dl>
							<dl>
								<dt>내용</dt>
								<dd>${noticeVo.noticeSubject }</dd>
							</dl>
						</form>
					</div>
				</div>

			</div>
			<div>

				<button type="button" class="btn btn-success"
					onclick="noticeUpdate(${noticeVo.noticeId })">수정</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-success"
					onclick="noticeDelete(${noticeVo.noticeId })">삭제</button>
			</div>

			<table>
			<c:choose>
				<c:when test= "${not empty replyList }">
					<c:forEach items="${replyList}" var="reply">
						<h3>enter!!!!!!</h3>	
						<span>${reply.commentWriter }</span>
						<tr class="colored">
							<td>${reply.commentWriter }</td>
							<td>${reply.commentContent }</td>
							<td>${reply.commentDate }</td>
						</tr>
						
					</c:forEach>
				</c:when>
				
				<c:otherwise>
					<tr>
						<td colspan="6" align="center">댓글이 존재하지 않습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</table>




			<script type="text/javascript">
	function noticeDelete(id) {
			
			const xhr = new XMLHttpRequest();
			const url = "noticeDelete.do?noticeid=" + id;
			xhr.onload = function() {
				if (xhr.status >= 200 && xhr.status < 300) {
					if (xhr.response == 1) {
						alert("데이터가 삭제되었습니다.");
						location.href = "noticeList.do";
					} else {
						alert("데이터가 삭제되지 않았습니다.");
					}
				};					
			} 
			xhr.open('GET', url);
			xhr.send();
		}
		
	</div>
		</script>
</body>
</html>