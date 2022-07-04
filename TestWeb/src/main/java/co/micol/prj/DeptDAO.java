package co.micol.prj;

import java.util.ArrayList;
import java.util.List;

public class DeptDAO extends DAO{
	
	public List<DeptVO> DeptListAll() {
		List<DeptVO> list = new ArrayList<DeptVO>();
		
		try {
			getConnect();
			String sql = "select * from departments";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDeptId(rs.getInt(1));
				vo.setDeptName(rs.getString(2));
				vo.setDeptManagerId(rs.getInt(3));
				vo.setDeptLocationId(rs.getInt(4));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return list;
		 
	}

}
