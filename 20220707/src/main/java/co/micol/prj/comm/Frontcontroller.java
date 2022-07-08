package co.micol.prj.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;
import co.micol.prj.member.command.AjaxMemberIdCheck;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;

/**
 * Servlet implementation class Frontcontroll
 */
@WebServlet("*.do") // 모든 .do요청은 내가 처리한다.
public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<>();// 요청과 실행문을 매핑하기 위해

	public Frontcontroller() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		// 초기화하는 메소드(Mapping 하는 부분을 작성한다.)
		map.put("/main.do", new MainCommand());// 처음 접속하는 페이지
		map.put("/memberLoginForm.do", new MemberLoginForm());// 로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin());// 로그인처리
		map.put("/memberLogout.do", new MemberLogout());// 로그아웃처리
		map.put("/memberList.do", new MemberList());// 회원목록처리
		map.put("/memberJoinForm.do", new MemberJoinForm());// 회원가입 폼
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck());// ajax를 이용한 중복처리 체크
		map.put("/memberJoin.do", new MemberJoin());//회원가입처리
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실행하는 메소드(서비스 해주는 것)
		request.setCharacterEncoding("utf-8");// 한글깨짐방지
		String uri = request.getRequestURI();// 요청된 URI를 확인한다.
		String contextPath = request.getContextPath();// 요청 URL로 부터 contextPath를 확인한다.
		String page = uri.substring(contextPath.length());// 실제 요청 페이지를 찾는다.
		System.out.println("page " + page);
		Command command = map.get(page);// 실제 수행할 Command를찾음 new MainCommand();
		String viewPage = command.exec(request, response);// 요청 Command를 수행하고 결과를 받음.
		System.out.println("viewPage " + viewPage);

		// viewResolve 보여줄페이지나 돌려줄페이지를 선택해주는 코드
		if (!viewPage.endsWith(".do") && !viewPage.equals(null)) {
			if (viewPage.startsWith("ajax:")) {//ajax처리하는 뷰 리졸브
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";// 시스템에서 접근 가능한 폴더를 더해주고
			System.out.println("viewPage");
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);// 원하는 페이지를 호출해서 전달함.

		} else {
			response.sendRedirect(viewPage);// .do로 권한 위임 처리
		}

	}
	

}
