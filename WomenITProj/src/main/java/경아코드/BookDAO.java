package 경아코드;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends DAO{

	public List<BookVO> bookList(){
		getConnect();
		String sql ="select * from book";
		List<BookVO> list = new ArrayList<BookVO>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookName(rs.getString("book_name"));
				vo.setBookAuth(rs.getString("book_auth"));
				vo.setBookPres(rs.getString("book_pres"));
				vo.setBookAmt(rs.getInt("book_amt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}



	public BookVO insertBook(BookVO vo) {
		getConnect();
		String sql = "insert into book values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookName());
			psmt.setString(3, vo.getBookAuth());
			psmt.setString(4, vo.getBookPres());
			psmt.setInt(5, vo.getBookAmt());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력완료.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}


	public boolean deleteBook(String code) {
		getConnect();
		String sql = "delete from book where book_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println(r + "건 삭제완료.");
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