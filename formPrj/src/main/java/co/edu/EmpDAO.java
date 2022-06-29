package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO extends DAO {
	
	// 입력기능
	public boolean insertSchedule(CalendarVO vo) {
		// 정상적으로 한건 입력이 되면 -> true.
		// 예외, 0건 -> false.
		getConnect();
		String sql = "insert into full_calendar \r\n"
				+ "VALUES (?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStartDate());
			psmt.setString(3, vo.getEndDate());
			int r = psmt.executeUpdate(); // r건입력
			
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
	
	// 삭제기능
	public boolean deleteSchedule(CalendarVO vo) {
		getConnect();
		String sql = "DELETE FROM full_calendar\r\n"
				+ "WHERE title=?\r\n";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			//psmt.setString(2, vo.getStartDate());
			//psmt.setString(3, vo.getEndDate());
			
			int r = psmt.executeUpdate(); // r건 삭제
			
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
	
	// 일정정보
	public List<CalendarVO> getSchedule() {
		// 전체 일정정보를 가지고 오도록 메소드 완성하세요.
		List<CalendarVO> schedule = new ArrayList<CalendarVO>();
		getConnect();
		String sql = "select *\r\n"
				+ "from full_calendar";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CalendarVO calVo = new CalendarVO();
				calVo.setTitle(rs.getString(1));
				calVo.setStartDate(rs.getString(2));
				calVo.setEndDate(rs.getString(3));
				schedule.add(calVo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			disConnect();
		}
		
		
		return schedule;
	}
	
	// 부서정보, 인원정보
	public Map<String, Integer> getDeptCnt(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		getConnect();
		String sql = "select department_name, count(1)\r\n"
				+ "from employees e, departments d\r\n"
				+ "where e.department_id = d.department_id\r\n"
				+ "group by department_name";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return map;
		
	}

	// class => 복합적인 데이터를 하나의 변수에다가.
	// 사원번호, 이름, 이메일, 직무 ... 이런것을 하나의 변수에 담을수 없기 때문에 -> calss작성 : 필드로 선언.
//	public void insertEmp(int eId, String name, String email,String job) {
//	하나하나 매개변수에 적어줘야한다. 
//	}
	public void insertEmp(Employee emp) {
		getConnect();
		String sql = "insert into employees (employee_id, last_name, email, job_id, hire_date) values(employees_seq.nextval,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getJobId());
			psmt.setString(4, emp.getHireDate());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	public List<String> getNames() {
		getConnect();
		String sql = "select first_name from employees";
		List<String> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public List<Employee> empList() {
		getConnect();
		String sql = "select * from employees";
		List<Employee> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql); // 쿼리를 실행하고 받아오는 
			rs = psmt.executeQuery(); // 실제 실행
			while (rs.next()) { // 한건씩 읽어오겠다.
				Employee emp= new Employee();
				emp.setEmail(rs.getString("email"));
				emp.setEmpId(rs.getInt("employee_id"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setLastName(rs.getString("last_name"));
				
				
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

}
