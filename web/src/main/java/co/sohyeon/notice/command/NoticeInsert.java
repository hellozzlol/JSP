package co.sohyeon.notice.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.sohyeon.command.Command;
import co.sohyeon.notice.service.NoticeService;
import co.sohyeon.notice.serviceImpl.NoticeServiceImpl;
import co.sohyeon.notice.vo.NoticeVO;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 등록(파일 업로드 포함)
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String savePath = "C:\\Temp\\"; //파일저장위치 "fileSave"
		int n=0;
		int upLoadSize = 1024*1024*1024;//최대파일 100MB
		
		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, upLoadSize,"utf-8"
					, new DefaultFileRenamePolicy());
			String orignalFileName = multi.getOriginalFileName("file");
			String saveFileName = multi.getFilesystemName("file");
			vo.setNoticeWriter(multi.getParameter("noticeWriter"));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeDate(Date.valueOf(multi.getParameter("noticeDate")));
			vo.setNoticeSubject(multi.getParameter("noticeSubject"));
			if(orignalFileName != null) {
				vo.setNoticeAttech(orignalFileName);
				saveFileName = savePath + saveFileName;//파일경로를 추가한다.
				vo.setNoticeAttechDir(saveFileName);
			}
			n= noticeDao.noticeInsert(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String returnPage = null;
		if(n !=0) {
			returnPage = "noticeList.do";
		}else {
			request.setAttribute("message", "게시글 등록이 실패했습니다");
			returnPage = "notice/noticeError";
		}
		return returnPage;
	}

}
