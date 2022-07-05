package co.micol.prj.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeptLsitServ
 */
@WebServlet("/DeptList")
public class DeptLsitServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", new DeptDAO().selectDept());
		request.getRequestDispatcher("/WEB-INF/jsp/Dept/deptLIst.jsp")
		.forward(request,response);
	}

	
	

}
