package co.micol.prj;

public class EmpVO {
private String employeeId;
private String firstname;
private String salary;



//인수 생성자▼(인수생성자를 만들면 꼭 기본생성자도 만들어줘야함)
public EmpVO(String employeeId, String firstname, String salary) {
	super();
	this.employeeId = employeeId;
	this.firstname = firstname;
	this.salary = salary;
}

//기본 생성자▼
public EmpVO() {
	super();
}

public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
	
}





}
