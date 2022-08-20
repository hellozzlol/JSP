package co.sohyeon.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sohyeon.command.Command;
import co.sohyeon.notice.service.NoticeService;
import co.sohyeon.notice.serviceImpl.NoticeServiceImpl;
import co.sohyeon.notice.vo.NoticeVO;



public class NoticeDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//게시글삭제
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.parseInt(request.getParameter("NoticeId")));
		int d = noticeDao.noticeDelete(vo);
		String jsonList ="0".trim();
		
		if(d !=0) {
			jsonList = "1";
			
		}
		
		return "ajax:"+jsonList;
	}

}
