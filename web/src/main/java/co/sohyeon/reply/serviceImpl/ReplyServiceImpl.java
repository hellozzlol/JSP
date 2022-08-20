package co.sohyeon.reply.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.sohyeon.command.DataSource;
import co.sohyeon.notice.vo.NoticeVO;
import co.sohyeon.reply.service.ReplyService;
import co.sohyoen.reply.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
		private DataSource dao = DataSource.getInstance();
		private Connection conn;
		private PreparedStatement psmt;
		private ResultSet rs;
	
	
	@Override
	public List<ReplyVO> replySelectList(NoticeVO noticeVo) {
		// 전체목록
		
		List<ReplyVO> list = new ArrayList<>();
		ReplyVO vo;
		String sql = "SELECT NO,WRITER,WDATE,CONTENT FROM REPLY WHERE notice_id = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, noticeVo.getNoticeId());
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new ReplyVO();
				vo.setCommentNo(rs.getInt("no"));
				vo.setCommentWriter(rs.getString("writer"));
				vo.setCommentDate(rs.getString("wdate"));
				vo.setCommentContent(rs.getString("content"));
				list.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return list;
	}

	@Override
	public ReplyVO replyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReplyVO replyDelete(ReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReplyVO replyUpdate(ReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
