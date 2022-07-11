package co.micol.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.comm.DataSourse;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private DataSourse dao = DataSourse.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		// 전체멤버목록
		List<MemberVO> list = new ArrayList<MemberVO>();// 결과를 담을 객체
		MemberVO vo;// 사용할매개변수
		String sql = "SELECT * FROM MEMBER";// 시퀄작성하고
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);// 밑에 있는 시퀄을 수행해주세요
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO(); // vo 초기화
				vo.setMemberId(rs.getString("member_id"));
				//vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_autor"));
				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVO memberSelectOne(MemberVO vo) {
		// 한명 조회
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberId(rs.getString("member_id"));
				//vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 회원 추가
				int n = 0;
				String sql = "INSERT INTO MEMBER(MEMBER_ID,MEMBER_PASSWORD,"
						+ "MEMBER_NAME, MEMBER_AUTOR) VALUES(?,?,?,?)";
				try {
					conn = dao.getConnection();
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getMemberId());  
					psmt.setString(2, vo.getMemberPassword());
					psmt.setString(3, vo.getMemberName());
					psmt.setString(4, vo.getMemberAuthor());
					n = psmt.executeUpdate();
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 회원정보 변경
	
				int n = 0;
				String sql = "UPDATE MEMBER SET MEMBER_PASSWORD = ?, "
						+ "MEMBER_AUTOR = ? WHERE MEMBER_ID = ?";
				try {
					conn = dao.getConnection();
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getMemberPassword());
					psmt.setString(2, vo.getMemberAuthor());
					psmt.setString(3, vo.getMemberId());
					n = psmt.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 회원정보 삭제
				int n = 0;
				String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
				try {
					conn = dao.getConnection();
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getMemberId());
					n = psmt.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return n;
	}

	@Override
	public boolean isMemberIdCheck(String id) {
		// 회원아이디 중복체크
		boolean b = false;
		String sql = "select member_id from member where member_id = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs= psmt.executeQuery();
			if(!rs.next()) { //존재하지 않으면 true, 존재하면 flase를 돌려준다.
				b = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return b;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// 회원 로그인
		String sql = "select * from member where member_id = ? and member_password = ?";
		try {
			conn=dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs= psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_autor"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt !=null) psmt.close();
			if(conn != null) conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

}
