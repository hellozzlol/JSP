package co.sohyeon.reply.service;

import java.util.List;

import co.sohyeon.notice.vo.NoticeVO;
import co.sohyoen.reply.vo.ReplyVO;


public interface ReplyService {
	//CRUD기본으로구성
	
	List<ReplyVO> replySelectList(NoticeVO noticeVo);//전체조회
	ReplyVO replyInsert(ReplyVO vo);//댓글입력
	ReplyVO replyDelete(ReplyVO vo);//댓글삭제
	ReplyVO replyUpdate(ReplyVO vo);//댓글수정

}
