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
	public EmpVO selectOne(String empId) {
		EmpVO vo = new EmpVO();
		try {
			getConnect();
			String sql = "select * "
					+ "from employees "
					+ "where EMPLOYEE_ID = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				vo.setLastName(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setHireDate(rs.getString("HIRE_DATE"));
				vo.setJobID(rs.getString("JOB_ID"));
				vo.setDepartmentId(rs.getString("DEPARTMENT_ID"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return vo;
	}
	
	// 검색조회
	public List<EmpVO> searchList(String deptId) {
		List<EmpVO> list = new ArrayList<>();
		try {
			getConnect();
			String sql = "select EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID, DEPARTMENT_ID "
					+ "from employees "
					+ "where DEPARTMENT_ID = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, deptId);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString(1));
				vo.setLastName(rs.getString(2));
				vo.setEmail(rs.getString(3));
				vo.setHireDate(rs.getString(4));
				vo.setJobID(rs.getString(5));
				vo.setDepartmentId(rs.getString(6));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return list;
	}

	// 등록
	public int insert(EmpVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "insert into employees (EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID, DEPARTMENT_ID) "
					+ "values ((select max(EMPLOYEE_ID)+1 from employees),?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobID());
			psmt.setString(5, vo.getDepartmentId());
			
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
					+ "set LAST_NAME=?, EMAIL=?, HIRE_DATE=?, JOB_ID=?, DEPARTMENT_ID=? "
					+ "where EMPLOYEE_ID=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobID());
			psmt.setString(5, vo.getDepartmentId());
			psmt.setString(6, vo.getEmployeeId());
			
			r = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return r;
	}

	// 삭제
	public int empDelete(String empId) {
		int r = 0;
		try {
			getConnect();
			String sql = "delete from employees "
					+ "where employee_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empId);
			r = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return r;
	}
}
