<%@page import="co.micol.prj.dept.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	height: 100vh;
	overflow: hidden;
	display: flex;
	align-items: center;
	justify-content: center;
	background-color: #5b6467;
	background-image: linear-gradient(315deg, #5b6467 0%, #8b939a 74%);
}

.noselect {
  -webkit-touch-callout: none;
    -webkit-user-select: none;
     -khtml-user-select: none;
       -moz-user-select: none;
        -ms-user-select: none;
            user-select: none;
		-webkit-tap-highlight-color: transparent;
}

button {
	width: 150px;
	height: 50px;
	cursor: pointer;
	font-size: 20px;
	font-family: 'Staatliches', cursive;
	letter-spacing: 5px;
	background: #ffc421;
	border: 2px solid black;
	box-shadow: 0px 0px 0px rgba(0,0,0,0.4);
	transition: 500ms;
	margin : 50px;
}

button:after {
	content: '';
	position: absolute;
	transform: translateX(-55px) translateY(-40px);
	width: 25px;
	height: 25px;
	border-radius: 50%;
	background: transparent;
	box-shadow: 0px 0px 50px transparent;
	transition: 500ms;
}

button:hover {
	transform: translateY(-5px);
	box-shadow: 0px 10px 10px rgba(0,0,0,0.4);
}

button:hover:after {
	background: white;
	box-shadow: 0px 0px 20px #ffc421, 0px 0px 30px #ffc421, inset 0px 0px 10px #ffc421;
	animation: spin 1s infinite linear;
}

@keyframes spin{
	25%{transform: translateX(-25px) translateY(-35px);
			width: 15px;
			height: 15px;}
	50% {transform: translateX(-55px) translateY(-30px);
			width: 5px;
			height: 5px;}
	75% {transform: translateX(-85px) translateY(-35px);
			width: 15px;
			height: 15px;}
}

button:focus {
	outline: none;
}


input[type=search]{
    
    width: 500px;
    height: 50px;
    font-size: larger;
    color: grey;
    margin: 0 auto;
    text-align: center;
    display: inline;
    
}
</style>
<meta charset="UTF-8">
<title>부서등록</title>



<script>
	function vaildationForm() {
		if (frm.departmentId.value == "") {
			alert("부서번호입력");
			return;
		}
		frm.submit();//폼 전송 (submit 버튼 클릭과 같음)
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<%
	DeptVO dept = (DeptVO) request.getAttribute("dept");
	%>
	<form name="frm" action="DeptUpdate" method="post">
		<div>
			<input type="search" name="departmentId" value="<%=dept.getDepartmentId()%> 부서번호"><br> 
				<input type="search" name="departmentName" value="<%=dept.getDepartmentName()%> 부서명"><br>
			<link href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap" rel="stylesheet">
			<button class="noselect" type="button"
				onclick="vaildationForm()">Registration</button>
		</div>
	</form>
	
	

	
	
	
	
	
	
	
	
	
	
	
</body>
</html>