<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<style>
* {
    margin: 0;
    padding: 0;
}

table {
    border-collapse: collapse;
}

caption {
    display: none;
}

a {
    text-decoration: none;
    color: inherit;
}

.board_list_wrap {
    padding: 50px;
}

.board_list {
    width: 100%;
    border-top: 2px solid green;
}

.board_list tr {
    border-bottom: 1px solid #ccc;
}

.board_list th,
.board_list td {
    padding: 10px;
    font-size: 14px;
}

.board_list td {
    text-align: center;
}

.board_list .tit {
    text-align: left;
}

.board_list .tit:hover {
    text-decoration: underline;
}

.board_list_wrap .paging {
    margin-top: 20px;
    text-align: center;
    font-size: 0;
}
.board_list_wrap .paging a {
    display: inline-block;
    margin-left: 10px;
    padding: 5px 10px;
    border-radius: 100px;
    font-size: 12px;
}
.board_list_wrap .paging a:first-child {
    margin-left: 0;
}

.board_list_wrap .paging a.bt {
    border: 1px solid #eee;
    background: #eee;
}

.board_list_wrap .paging a.num {
    border: 1px solid green;
    font-weight: 600;
    color: green;
}

.board_list_wrap .paging a.num.on {
    background: green;
    color: #fff;
}

.board_title {
    margin-bottom: 30px;
    font-size: 4.5em;
    font-style: italic;
    text-align: left;
    color: gray;
    padding-left: 3em;
    padding-right: 0.5em;
    padding-top: 1em;
    padding-bottom: 0.5em;
    float: left;
}
.board_title strong {
    font-size: 3rem;
}
.board_title p {
    margin-top: 5px;
    font-size: 1.4rem;
}

strong {
	font-size: 80px;
	color:#1abc9c;
}

.btn{
    margin: 20px;
}

</style>
</head>
<body>
	<div class="board_title" align="left">
		<strong>게시글목록</strong>
		<div>
			<form id="frm" method="post">
				<select id="key" name="key">
				  	<option value="notice_title">제목</option>
				  	<option value="notice_subject">내용</option>
				  	<option value="notice_writer">작성자</option>			  
				</select> &nbsp;
				<input type="text" id="val" name="val">&nbsp;&nbsp;
				<input type="button"class="btn btn-success" value="검색" onclick="noticeSearch()">
			</form>
		</div><br>
		
		 <div class="board_list_wrap" align="center">
      <table class="board_list">
				<thead>
					<tr>
						<th width="70">순번</th>
						<th width="130">작성자</th>
						<th width="200">제목</th>
						<th width="130">작성일자</th>
						<th width="180">첨부파일</th>
						<th width="70">조회수</th>
						<th width="70">삭제</th>								
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list }">
							<c:forEach items="${list }" var="b">
								<tr class="colored" onclick="noticeSelect(${b.noticeId })">
									<td>${b.noticeId }</td>
									<td>${b.noticeWriter }</td>
									<td>${b.noticeTitle }</td>
									<td>${b.noticeDate }</td>
									<td>${b.noticeAttech }</td>
									<td>${b.noticeHit }</td>
									
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6" align="center">
									게시글이 존재하지 않습니다
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div><br>
		<div>
		<c:if test="${author == 'ADMIN'}">
			<button type="button" onclick="location.href='noticeForm.do'">글등록</button>
		</c:if>
		</div>
	</div>
	
	<script type="text/javascript">
/* 		function noticeSearch() {
			let key = $("#key").val();
			let val = $("#val").val();
			$.ajax({
				url : "ajaxNoticeSearche.do",
				type : "post",
				data : {key : key, val : val},
				dataType : "json",
				success : function(result){
					if(result.length > 0) {
						jsonHtmlConvert(result);
					}else {
						alert("검색한 결과가 없습니다.");
					}
				},
				error : function() {
					
				}
			})
		} */
		
		function jsonHtmlConvert(data) {
			$('tbody').remove();
			var tbody = $("<tbody />");
			$.each(data, function(index, item){
				var row = $("<tr />").append(
							$("<td />").text(item.noticeId),
							$("<td />").text(item.noticeWriter),
							$("<td />").text(item.noticeTitle),
							$("<td />").text(item.noticeDate),
							$("<td />").text(item.noticeAttech),
							$("<td />").text(item.noticeHit),
							$("<td />").append($("<button onclick=delNotice(this) /> ").text("삭제"))
						);
				tbody.append(row);
			});
			$('table').append(tbody);
		}
		
		function noticeSearch() {  //XMLHttpRequest() 호출
			const ajax = new XMLHttpRequest();
			let key = document.getElementById('key').value;
			let val = document.getElementById('val').value;
			const url = "ajaxNoticeSearche.do";
			const data = {"key" : key,"val" : val};
			ajax.onload = function(){
				if(ajax.status >= 200 && ajax.status < 300){
					jsonHtmlConvert(ajax.response);
				}else {
					errorCallback(new Error(ajax.stautsText));
				}
			};
			
			ajax.onerror = errorCallback;
			ajax.open('POST',url,true);
			ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			ajax.responseType='json';
			ajax.send(Object.keys(data).map(key => key+"="+data[key]).join('&')); //  
		}
		
		function errorCallback(err){
			console.log('error : '+err.message);
		}
		
		function delNotice(obj){	
			let row = $(obj).parent().parent().get(0);
			let td = row.cells[0];
			let id = $(td).html();		
			
 			const xhr = new XMLHttpRequest();
			const url = "ajaxNoticeDelte.do?id="+id;
			xhr.onload = function(){
				if(xhr.status >= 200 && xhr.status < 300){
					if(xhr.response == 1) {
						alert("데이터가 삭제되었습니다.");
						$(row).remove();
					}else {
						alert("삭제 할 수 없습니다.");
					};
				}else {
					errorCallback(new Error(xhr.stautsText));
				}
			};
		
			xhr.open('GET',url);
			xhr.send(); 
		}
		
		function noticeSelect(id) {  //get방식 안전하지 않음
			location.href='noticeSelect.do?id='+id;			
		}
	</script>
</body>
</html>