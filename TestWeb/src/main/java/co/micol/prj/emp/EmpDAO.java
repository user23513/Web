package co.micol.prj.emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.comm.DAO;

public class EmpDAO extends DAO {
	
	// jobs 전체조회
	public List<JobsVO> selectJobs() {
		List<JobsVO> list = new ArrayList<JobsVO>();
		try {
			getConnect();
			String sql = "select * from jobs";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				JobsVO vo = new JobsVO();
				vo.setJobId(rs.getString(1));
				vo.setJobTitle(rs.getString(2));
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	

	// 전체조회
	public ArrayList<EmpVO> selectAll(String departmentId) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. DB 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID "
					+ " from employees ";
			if (departmentId != null && !departmentId.isEmpty()) {
				sql += "where department_id = ? ";
			}
			sql += " order by employee_id ";
			psmt = conn.prepareStatement(sql);
			if (departmentId != null && !departmentId.isEmpty()) {
				psmt.setString(1, departmentId);
			}
			// 실행
			ResultSet rs = psmt.executeQuery();
			// 조회결과 list에 담기
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				vo.setLastName(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setHireDate(rs.getString("HIRE_DATE"));
				vo.setJobID(rs.getString("JOB_ID"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB 연결해제
			disConnect();
		}
		return list;
	}

	// 단건조회
	public EmpVO selectOne(String id) {
		EmpVO vo = new EmpVO();
		try {
			getConnect();
			String sql = "select EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID "
					+ "from employees "
					+ "where department_id = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo.setEmployeeId(rs.getString(1));
				vo.setLastName(rs.getString(2));
				vo.setEmail(rs.getString(3));
				vo.setHireDate(rs.getString(4));
				vo.setJobID(rs.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return vo;
	}

	// 등록
	public int insert(EmpVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "insert into employees (EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID) "
					+ "values (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmployeeId());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobID());
			
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	// 수정
	public int empUpdate(EmpVO vo) {
		int r = 0;
		try {
			getConnect();
			String sql = "update employees "
					+ "set LAST_NAME=?, EMAIL=?, HIRE_DATE=?, JOB_ID=? "
					+ "where EMPLOYEE_ID=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobID());
			psmt.setString(5, vo.getEmployeeId());
			
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
