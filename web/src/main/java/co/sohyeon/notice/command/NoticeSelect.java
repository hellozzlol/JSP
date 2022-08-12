package co.sohyeon.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sohyeon.command.Command;
import co.sohyeon.notice.service.NoticeService;
import co.sohyeon.notice.serviceImpl.NoticeServiceImpl;
import co.sohyeon.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 조회
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("id")));
		vo = noticeDao.noticeSelect(vo);
		request.setAttribute("vo", vo);
		return "notice/noticeSelect";
	}

}
