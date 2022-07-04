package 경아코드;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		String cmd = request.getParameter("cmd");
		Gson gson = new GsonBuilder().create();// json데이터생성
		BookDAO dao = new BookDAO();

		if (cmd.equals("list")) {
			List<BookVO> list = dao.bookList();
			response.getWriter().print(gson.toJson(list));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String cmd = request.getParameter("cmd");

		BookDAO dao = new BookDAO();
		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();

		String bookCode = request.getParameter("bookCode");
		String bookName = request.getParameter("bookName");
		String bookAuth = request.getParameter("bookAuth");
		String bookPres = request.getParameter("bookPres");
		int bookAmt = 0;
		if(request.getParameter("bookAmt") != null) {
			bookAmt = Integer.parseInt(request.getParameter("bookAmt"));
		}else {
			bookAmt = 0;
		}
		System.out.println("bookAmt : "+bookAmt);

		BookVO vo = new BookVO();
		vo.setBookCode(bookCode);
		vo.setBookName(bookName);
		vo.setBookAuth(bookAuth);
		vo.setBookPres(bookPres);
		vo.setBookAmt(bookAmt);

		System.out.println("vo"+vo);

		if (cmd.equals("delete")) {
			String delCode = request.getParameter("delId");
			System.out.println("선택삭제 코드번호 "+delCode);
			if (dao.deleteBook(delCode)) {
				out.print("{\"retCode\":\"Success\"}");
			} else {
				out.print("{\"retCode\":\"Fail\"}");
			}

		} else if (cmd.equals("insert")) {
			dao.insertBook(vo);
			out.print(gson.toJson(vo));

		}

	}

}