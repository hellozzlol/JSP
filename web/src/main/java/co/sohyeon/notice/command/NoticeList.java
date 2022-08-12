package co.sohyeon.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sohyeon.command.Command;
import co.sohyeon.notice.service.NoticeService;
import co.sohyeon.notice.serviceImpl.NoticeServiceImpl;
import co.sohyeon.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글목록가져오기
		NoticeService noticeDao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<>();
		list = noticeDao.noticeSelectList();
		request.setAttribute("list", list);
		return "notice/noticeList";
		
	}

}
