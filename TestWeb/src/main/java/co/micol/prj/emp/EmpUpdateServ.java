package co.micol.prj.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

@WebServlet("/empUpdate")
public class EmpUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpUpdateServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		request.setAttribute("emp", new EmpDAO().selectOne(empId));
		request.setAttribute("jobs", new EmpDAO().selectJobs());
		request.setAttribute("depts", new DeptDAO().DeptListAll());
		
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		EmpDAO dao = new EmpDAO();
		EmpVO vo = new EmpVO();
		
		String id = request.getParameter("employeeId");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jobID = request.getParameter("jobID");
		String deptId = request.getParameter("deptId");
		
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobID(jobID);
		vo.setDepartmentId(deptId);
		
		int r = dao.empUpdate(vo);
		response.getWriter().append(r + "건이 수정됨");
	}

}
