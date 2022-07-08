package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); // 멤버전체 조회 R(select)
	MemberVO memberSelectOne(MemberVO vo);//멤버조회 R
	int memberInsert(MemberVO vo); //멤버 삽입 C
	int memberUpdate(MemberVO vo); //멤버 수정 U
	int memberDelete(MemberVO vo); //멤버 삭제 D
	
	boolean isMemberIdCheck(String id); //아이디 중복체크 (존재하면false 존재하지않으면 true면사용가능하게 하고 boolean 메서드는is를 부름)
	MemberVO memberLogin(MemberVO vo);//로그인 처리 R
	
	
	

}
