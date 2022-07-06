package co.micol.prj.board;

import java.util.ArrayList;
import java.util.List;

import co.micol.prj.comm.DAO;

public class BoardDAO extends DAO{

	// 전체 조회
	public List<BoardVO> selectAll() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			getConnect();
			String sql = "select * from board "
					+ "order by id desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRdt(rs.getString("rdt"));
				vo.setHit(rs.getString("hit"));
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return list;
	}
	
	// 단건 조회
	public BoardVO selectOne(String id) {
		BoardVO vo = new BoardVO();
		try {
			getConnect();
			String sql = "select * from board "
					+ "where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setRdt(rs.getString(5));
				vo.setHit(rs.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return vo;
	}
	
	
	// 입력
	public int insert(BoardVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "insert into board "
					+ "values ((select max(id)+1 from board),?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getRdt());
			psmt.setString(5, vo.getHit());
			
			cnt =  psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return cnt;
	}
	
}
