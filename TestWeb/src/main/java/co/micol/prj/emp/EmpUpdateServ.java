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
@WebServlet("/empUpdate")
public class EmpUpdateServ extends HttpServlet {

	// 수정페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB조회
		// jobs, 부서, 사원
		EmpDAO EmpDAO = new EmpDAO();
		request.setAttribute("jobs", new EmpDAO().selectJobs());
		DeptDAO deptDAO = new DeptDAO();
		request.setAttribute("depts",deptDAO.selectDept());
		//수정할 사원의 사번을받아서 단건조회
		String employeeId =request.getParameter("employeeId");
		request.setAttribute("emp", EmpDAO.selectOne(employeeId));
		
		request.getRequestDispatcher("/WEB-INF/jsp/Emp/empUpdate.jsp").forward(request, response);
	}

	// 등록처리

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		// 파라미터 ID 담고
		String id = request.getParameter("employeeId");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String jobid = request.getParameter("jobId");
		String hiredate = request.getParameter("hireDate");

		EmpVO vo = new EmpVO();
		
		vo.setEmployeeId(id);
		vo.setLastname(name);
		vo.setEmail(email);
		vo.setJobId(jobid);
		vo.setHiredate(hiredate);

		// DB처리
		EmpDAO EmpDAO = new EmpDAO();
		int cnt = EmpDAO.update(vo);

		// 결과출력
		response.getWriter()

				.append(cnt + "건이 등록됨");

	}

}
