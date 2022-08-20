package co.sohyeon.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sohyeon.command.Command;
import co.sohyeon.notice.service.NoticeService;
import co.sohyeon.notice.serviceImpl.NoticeServiceImpl;
import co.sohyeon.notice.vo.NoticeVO;
import co.sohyeon.reply.service.ReplyService;
import co.sohyeon.reply.serviceImpl.ReplyServiceImpl;
import co.sohyoen.reply.vo.ReplyVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 조회
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO noticeVo = new NoticeVO();
		noticeVo.setNoticeId(Integer.valueOf(request.getParameter("id")));
		noticeVo = noticeDao.noticeSelect(noticeVo);
		request.setAttribute("noticeVo", noticeVo);
		
		// 댓글 리스트가져오기
		ReplyService replyDao = new ReplyServiceImpl();
		List<ReplyVO> replyList = replyDao.replySelectList(noticeVo);
		System.out.println(replyList);
		request.setAttribute("replyList", replyList);
		
		return "notice/noticeSelect";
	}

}