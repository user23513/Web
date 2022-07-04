package co.micol.prj;

public class DeptVO {
	private int deptId;
	private String deptName;
	private int deptManagerId;
	private int deptLocationId;
	
	
	public DeptVO() {
	}
	
	
	public DeptVO(int deptId, String deptName, int deptManagerId, int deptLocationId) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptManagerId = deptManagerId;
		this.deptLocationId = deptLocationId;
	}


	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getDeptManagerId() {
		return deptManagerId;
	}
	public void setDeptManagerId(int deptManagerId) {
		this.deptManagerId = deptManagerId;
	}
	public int getDeptLocationId() {
		return deptLocationId;
	}
	public void setDeptLocationId(int deptLocationId) {
		this.deptLocationId = deptLocationId;
	}
	
	

}
