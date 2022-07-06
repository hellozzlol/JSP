package co.micol.prj.emp;

public class EmpVO {
private String employeeId;
private String lastname;
private String email;
private String jobId;
private String hiredate;
private String departmentId;



//인수 생성자▼(인수생성자를 만들면 꼭 기본생성자도 만들어줘야함)
public EmpVO() {
	super();
	this.employeeId = employeeId;
	this.lastname = lastname;
	this.email = email;
	this.jobId=jobId;
	this.hiredate = hiredate;
	this.departmentId = departmentId;

}


//기본 생성자▼

public String getEmployeeId() {
	return employeeId;
}



public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}


public String getLastname() {
	return lastname;
}



public String getDepartmentId() {
	return departmentId;
}


public void setDepartmentId(String departmentId) {
	this.departmentId = departmentId;
}


public void setLastname(String lastname) {
	this.lastname = lastname;
}



public String getJobId() {
	return jobId;
}


public void setJobId(String jobId) {
	this.jobId = jobId;
}


public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}






public String getHiredate() {
	return hiredate;
}



public void setHiredate(String hiredate) {
	this.hiredate = hiredate;
}





}
