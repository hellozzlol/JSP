<%@page import="co.micol.prj.emp.EmpVO"%>
<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.micol.prj.emp.jobsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
<script>
function validateForm(){
	if(document.frm.employeeId.value =="" ){
		alert("사원번호를 입력해주세요^_^")
				frm.employeeId.focus();
		return false;
	}
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
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<body>
사원 등록   
<%
EmpVO vo = (EmpVO)request.getAttribute("emp");

%>
   <form name="frm" action="empInsert" method="post" onsubmit="return validateForm()">
   <label for="empId">사원번호</label>
   <input type="text" name="employeeId" id="empId" readonly="readonly" value="<%=vo.getEmployeeId()%>"><br> 
   
   <label for="empName">사원이름</label>
   <input type="text" name="lastName" id="empName" value="<%=vo.getLastname()%>"><br>
   
   <label for="empEmail">이메일</label>
   <input type="text" name="email" id="empEmail" value="<%=vo.getEmail()%>"><br>
   
   
   
   <label for="hireDate">입사일</label>
   <input type="date" name="hireDate" id="hireDate" value="<%=vo.getHiredate().substring(0, 10)%>"><br>
   
   <label for="hireDate">부서</label><br>
     <% ArrayList<DeptVO> depts =(ArrayList<DeptVO>)request.getAttribute("depts");
   for(DeptVO dept : depts) { 
   
   
   %>
  
   <input type="radio" name ="departmentId" value="<%=dept.getDepartmentId()%>" 
   <%if(dept.getDepartmentId().equals(vo.getDepartmentId())){ %>checked="checked"<%} %> >
   <%=dept.getDepartmentName() %>
   <% } %>
   

   
   
   
   <label for="hireDate">직무<select name="jobId"></label><br>
   
   <% ArrayList<jobsVO> list =(ArrayList<jobsVO>)request.getAttribute("jobs");
   for(jobsVO jobs : list) { %>
   <option value="<%=jobs.getJobId()%>"> <%=jobs.getJobTitle()%>
   <% } %>
   </select>
   <button>사원수정</button>
   <button type="button" onclick="empDelete()">사원삭제</button>
   </form>
<script>
function empDelete(){
	location.href="empDelete?employeeId=<%=vo.getEmployeeId()%>";
}
document.getElementsByName("jobId")[0].value = "<%=vo.getJobId()%>";
</script>
</body>
</html>
