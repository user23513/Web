package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import co.micol.prj.dept.DeptDAO;

@WebServlet("/empInsert")
public class EmpInsertServ extends HttpServlet {

	// 등록페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB조회
		//jobs, 부서, 사원
		request.setAttribute("jobs", new EmpDAO().selectJobs());
		request.setAttribute("depts", new DeptDAO().DeptListAll());
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp")
		   .forward(request, response);
	}

	// 등록처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		EmpDAO dao = new EmpDAO();
		
		String id = request.getParameter("employeeId");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jobId = request.getParameter("jobID");
		
		
		EmpVO vo = new EmpVO();
		
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobID(jobId);
		
		int cnt = dao.insert(vo);
		
		response.getWriter().append(cnt + "건이 등록됨");
		
//		request.setAttribute("list", dao.selectAll(id));
//		request.getRequestDispatcher("WEB-INF/jsp/emp/empList.jsp").forward(request, response);
	}
	
	
	

}
