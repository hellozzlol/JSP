package co.micol.prj.board;

import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class BoardDAO extends DAO{

	//전체조회
	
	public ArrayList<BoardVO> selectAll(){
		ArrayList<BoardVO>list = new ArrayList<>(); 
		
		try {
			getConnect();
			String spl = "select * from board order by id desc";
			psmt=conn.prepareStatement(spl);
			rs= psmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getString("hit"));
				vo.setRdt(rs.getString("rdt"));
				vo.setWriter(rs.getString("writer"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
		
	}
	
	
}
