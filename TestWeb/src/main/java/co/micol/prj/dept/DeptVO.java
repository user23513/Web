package co.micol.prj.dept;

public class DeptVO {
	private String deptId;
	private String deptName;
	private String deptManagerId;
	private String deptLocationId;
	
	
	public DeptVO() {
	}
	
	
	public DeptVO(String deptId, String deptName, String deptManagerId, String deptLocationId) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptManagerId = deptManagerId;
		this.deptLocationId = deptLocationId;
	}


	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getDeptManagerId() {
		return deptManagerId;
	}


	public void setDeptManagerId(String deptManagerId) {
		this.deptManagerId = deptManagerId;
	}


	public String getDeptLocationId() {
		return deptLocationId;
	}


	public void setDeptLocationId(String deptLocationId) {
		this.deptLocationId = deptLocationId;
	}


	
	
	

}
