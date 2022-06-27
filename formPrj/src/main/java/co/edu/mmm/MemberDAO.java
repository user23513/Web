package co.edu.mmm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.DAO;




public class MemberDAO extends DAO {
	          
	// 전체조회 하는 기능 ()
	public List<MemberVO> memberList() {
		getConnect();
		List<MemberVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from member order by memb_no"); // prepareStatement("쿼리문")=>쿼리들을 실행할수있는 객체를 리턴해줌
			rs = psmt.executeQuery(); // 조회:executeQuery / 추가,수정,삭제:executeUpdate
			while(rs.next()) { // next()=>가지고 있는 데이터가 있으면 true를 리턴함.
				MemberVO mem = new MemberVO();
				mem.setMembNo(rs.getInt("memb_no"));
				mem.setMembName(rs.getString("memb_name"));
				mem.setMembPhone(rs.getString("memb_phone"));
				mem.setMembAddr(rs.getString("memb_addr"));
				mem.setMembBirth(rs.getString("memb_birth"));
				mem.setMembImage(rs.getString("memb_image"));
				
				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 사용했던 리소스 반환
		}
		return list;
	}
	
	// 입력하는 기능 (MemberVO)
	public MemberVO insertMember(MemberVO vo) {
		getConnect();
		String seqSql = "select memb_seq.nextval from dual";
		
		try {
			//시퀀스 => 회원번호
			int nextSeq = 0;
			psmt = conn.prepareStatement(seqSql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				nextSeq = rs.getInt(1); // 컬럼의 순서상으로 1
			}
			
			// 입력 처리.
			psmt = conn.prepareStatement("insert into member (memb_no, memb_name, memb_phone, memb_addr, memb_birth, memb_image) "
					+ "values(?,?,?,?,?,?)"); // 값을 나중에 넘겨주겠습니다.
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getMembName());
			psmt.setString(3, vo.getMembPhone());
			psmt.setString(4, vo.getMembAddr());
			psmt.setString(5, vo.getMembBirth());
			psmt.setString(6, vo.getMembImage());
			
			vo.setMembNo(nextSeq);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			disConnect();
		}
		
		return vo;
	}
	
	// 수정하는 기능 (MemberVO)
	public boolean updateMember(MemberVO vo) {
		getConnect();
		try {
			psmt = conn.prepareStatement("update member "
									   + "set    memb_name = ?,"
									   + "		 memb_phone = ?,"
									   + "		 memb_addr = ?,"
									   + "		 memb_birth = ?,"
									   + "	  	 memb_image = ?"
									   + "where  memb_no = ?");
			
			psmt.setString(1, vo.getMembName());
			psmt.setString(2, vo.getMembPhone());
			psmt.setString(3, vo.getMembAddr());
			psmt.setString(4, vo.getMembBirth());
			psmt.setString(5, vo.getMembImage());
			psmt.setInt(6, vo.getMembNo());
			
			int r = psmt.executeUpdate(); // 수정된 건수를 반환해주는 메소드
			if(r > 0) {
				return true; // 정상적으로 처리되었습니다.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			disConnect();
		}
		
		return false;
	}
	
	// 삭제하는 기능 (memb_no)
	public boolean deleteMember(int membNo) {
		getConnect();
		try {
			psmt = conn.prepareStatement("delete from member "
									   + "where memb_no = ?");
			psmt.setInt(1, membNo);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			disConnect();
		}
		
		return false;
	}
	
	// 조건으로 조회하는 기능 (memb_no)
	public MemberVO searchMember(int membNo) {
		getConnect();
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement("select * from member where memb_no = ?");
			psmt.setInt(1, membNo);
			rs = psmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
				member.setMembNo(rs.getInt("memb_no"));
				member.setMembName(rs.getString("memb_name"));
				member.setMembPhone(rs.getString("memb_phone"));
				member.setMembAddr(rs.getString("memb_addr"));
				member.setMembBirth(rs.getString("memb_birth"));
				member.setMembImage(rs.getString("memb_image"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			disConnect();
		}
		
		return member;
	}
	

}
