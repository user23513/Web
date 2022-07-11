package co.micol.prj.member.service;

import java.util.ArrayList;
import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService { 
	
	//CRUD
	List<MemberVO> memberSelectList();     // 멤버전체조회 R
	MemberVO memberSelectOne(MemberVO vo); // 멤버단건조회 R
	int memberInsert(MemberVO vo); // 멤버등록 C
	int memberUpdate(MemberVO vo); // 멤버수정 U
	int memberDelete(MemberVO vo); // 멤버삭제 D
	
	//----------------------------------------------
	boolean isMemberIdCheck(String id); // 아이디 중복체크 (존재하면 false(사용하지 못한다) => 그래서 is를 관례적으로 붙인다.)
	MemberVO memberLogin(MemberVO vo); // 로그인 처리 R
	
}
