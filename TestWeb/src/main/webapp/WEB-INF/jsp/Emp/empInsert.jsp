<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.micol.prj.emp.jobsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>empInsert.jsp</title>
<script>
function validateForm(){
	/* if(document.frm.employeeId.value =="" ){
		alert("사원번호를 입력해주세요^_^")
				frm.employeeId.focus();
		return false;
	} */
	if(document.frm.lastName.value =="" ){
		alert("이름를 입력해주세요^_^")
				frm.lastName.focus();
		return false;
	}
	if(document.frm.email.value =="" ){
		alert("이메일 입력해주세요^_^")
				frm.email.focus();
		return false;
	}
	
	
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(regExp.test(frm.email.value)== false){
		alert("이메일형식이 올바르지않습니다 ^_^")
				frm.email.focus();
		return false;
	}
	return true;
	
	if(document.frm.jobId.value =="" ){
		alert("부서이름를 입력해주세요^_^")
				frm.jobId.focus();
		return false;
	}
	if(document.frm.hireDate.value =="" ){
		alert("입사일 입력해주세요^_^")
				frm.hireDate.focus();
		return false;
	}
	return true;
}

</script>
</head>
<style>
button{
   
   width: 150px;
   height: 50px;
   font-size: larger;
   color:rgb(255, 255, 255);
   background-color: rgb(255, 0, 0);
   font-weight: bold;
   margin:10px;
   text-align: center;
   display: inline;
  
}

h2{
color: skyblue;
}
</style>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<body>
<h2>사원 등록</h2>   
   <form name="frm" action="empInsert" method="post" onsubmit="return validateForm()">
   <label for="empId">사원번호</label>
   <input type="text" name="employeeId" id="empId"><br> 
   
   <label for="empName">사원이름</label>
   <input type="text" name="lastName" id="empName"><br>
   
   <label for="empEmail">이메일</label>
   <input type="text" name="email" id="empEmail"><br>
   
   
   
   <label for="hireDate">입사일</label>
   <input type="date" name="hireDate" id="hireDate"><br>
   
   <label for="hireDate">부서</label><br>
     <% ArrayList<DeptVO> depts =(ArrayList<DeptVO>)request.getAttribute("depts");
   for(DeptVO dept : depts) { %>
   
   <input type="radio" name ="departmentId" value="<%=dept.getDepartmentId()%>"><%=dept.getDepartmentName() %>
   <% } %>
   

   
   
   
   <br><label for="hireDate">직무<select name="jobId"></label><br>
   
   <% ArrayList<jobsVO> list =(ArrayList<jobsVO>)request.getAttribute("jobs");
   for(jobsVO jobs : list) { %>
   <option value="<%=jobs.getJobId()%>"><%=jobs.getJobTitle() %>
   <% } %>
   </select><br>
   <button>사원 등록</button>
   </form>

</body>
</html>
