package co.micol.prj.dept;

import java.util.ArrayList;
import java.util.List;

import co.micol.prj.comm.DAO;

public class DeptDAO extends DAO {

	// 전체조회
	public List<DeptVO> DeptListAll() {
		List<DeptVO> list = new ArrayList<DeptVO>();

		try {
			getConnect();
			String sql = "select * from departments";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDeptId(rs.getString(1));
				vo.setDeptName(rs.getString(2));
				vo.setDeptManagerId(rs.getString(3));
				vo.setDeptLocationId(rs.getString(4));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;

	}

	// 단건조회
	public DeptVO selectOne(String department_id) {
		DeptVO vo = new DeptVO();

		try {
			getConnect();
			String sql = "select * from departments where department_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, department_id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setDeptId(rs.getString(1));
				vo.setDeptName(rs.getString(2));
				vo.setDeptManagerId(rs.getString(3));
				vo.setDeptLocationId(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return vo;

	}

	// 등록
	public int deptInsert(DeptVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = " insert into departments" + " values (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDeptId());
			psmt.setString(2, vo.getDeptName());
			psmt.setString(3, vo.getDeptManagerId());
			psmt.setString(4, vo.getDeptLocationId());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return cnt;
	}

	
	// 수정
	public int deptUpdate(DeptVO vo) {
		int r = 0;
		try {
			getConnect();
			String sql = "update departments "
					+ "set DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=?"
					+ "where DEPARTMENT_ID=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDeptName());
			psmt.setString(2, vo.getDeptManagerId());
			psmt.setString(3, vo.getDeptLocationId());
			psmt.setString(4, vo.getDeptId());
			
			r = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return r;
	}

	// 삭제

}
