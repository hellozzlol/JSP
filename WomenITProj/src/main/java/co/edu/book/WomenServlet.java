package co.edu.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/WomenServlet")
public class WomenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WomenServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 응답정보에 한글처리 방식 .
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/json;charset=utf-8");
				
				String cmd = request.getParameter("cmd");
				Gson gson = new GsonBuilder().create();// json 데이터생성
				WomenDAO dao = new WomenDAO();
				
				if(cmd.equals("list")){
					//전체리스트 =>json파일보여주기 
					System.out.println(cmd);
					List<WomenVO> list = dao.WomenList();
					response.getWriter().print(gson.toJson(list));
					System.out.println(list);
				System.out.println(list);
				}else if(cmd.equals("insert")) {
					// 도서이름변경
					
					String bookname= request.getParameter("name");
					String bookcode= request.getParameter("code");
					
					WomenVO vo = new WomenVO();
					
					
					vo.setBookName(bookname);
					vo.setBookCode(bookcode);
					
					
					
					
					
					
					
					
					
			
				}
				
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
