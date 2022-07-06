package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;
import co.micol.prj.dept.DeptVO;

//http://localhost/컨텍스트패스//empInsert
@WebServlet("/empDelete")
public class EmpDeleteServ extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 파라미터
	String employeeId=	request.getParameter("employeeId");
	response.setContentType("text/html; charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
		// 매소드,delete메서드
		EmpDAO dao = new EmpDAO();
		EmpVO vo=new EmpVO();
		vo.setEmployeeId(employeeId);
		int cnt = dao.delete(vo);
	
		response.getWriter()
		.append("<script >")
		.append("alert('"+cnt+" 건 이 삭제완료 ');")
		.append("location.href='empList';")
		.append("</script>");
		
		
//		request.setAttribute("msg",cnt + " 이 삭제됨");
//		request.getRequestDispatcher("WEB-INF/jsp/message.jsp")
//		.forward(request, response);
		//response.sendRedirect("empList");
		
		
	}



}
