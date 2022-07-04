package co.edu.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







public class WomenDAO extends DAO {
//전체조회
	public List<WomenVO> WomenList() {
		getConnect();
		String sql = "select * from book";
		List<WomenVO> list = new ArrayList<>();
	
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				WomenVO book = new WomenVO();
				book.setBookCode(rs.getString("BOOK_CODE"));
				book.setBookName(rs.getString("BOOK_NAME"));
				book.setBookWriter(rs.getString("BOOK_AUTH"));
				book.setBookpublisher(rs.getString("BOOK_PRES"));
				book.setBookPrice(rs.getInt("BOOK_AMT"));

				list.add(book);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;

}
	
	//입력.(WomenVO)
	
	public WomenVO insertBook(WomenVO vo) {
		getConnect();
		try {
			// 시퀀스
			int nextSeq = 0;
			String seqSql = "select memb_seq.nextval from dual";
			psmt = conn.prepareStatement(seqSql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				nextSeq = rs.getInt(1); // 회원번호.
			}
			// 입력처리.
			psmt = conn.prepareStatement(
					"insert into book(BOOK_CODE,BOOK_NAME,BOOK_AUTH,BOOK_PRES,BOOK_AMT) values(?,?,?,?,?)");
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getBookCode());
			psmt.setString(3, vo.getBookName());
			psmt.setString(4, vo.getBookWriter());
			psmt.setString(5, vo.getBookpublisher());
			psmt.setInt(6, vo.getBookPrice());
			vo.setBookPrice(nextSeq);
			int r = psmt.executeUpdate();

			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	
	
	// 삭제.(memb_no)
		public boolean deleteMember(int BOOK_AMT) {
			getConnect();
			String spl = "delete from book where Book_Code=?";
			try {
				psmt = conn.prepareStatement(spl);
				psmt.setInt(1, BOOK_AMT);
				int r = psmt.executeUpdate();// 삭제
				if (r > 0) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}

			return false;
		}
	
	
	
	
	
	
	
	
	
}