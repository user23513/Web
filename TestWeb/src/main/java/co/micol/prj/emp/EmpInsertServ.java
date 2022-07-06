package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import co.micol.prj.dept.DeptDAO;

//http://lacalhost/contextPath/empInsert
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
		String deptId = request.getParameter("deptId");
		
		
		EmpVO vo = new EmpVO();
		
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobID(jobId);
		vo.setDepartmentId(deptId);
		
		int cnt = dao.insert(vo);
		
		
		//결과출력
//		response.getWriter().append(cnt + "건이 등록됨");
//		request.getRequestDispatcher("empList").forward(request, response); -> 등록버튼 눌렀을 때 empInsert로 가고/ forward(전달) 최종페이지결과만 넘어간다.(결과를 가지고 jsp(뷰페이지)로 넘어갈때 사용)
		response.sendRedirect("empList");								  //-> 등록버튼 눌렀을 때 empList로 가고 / 브라우저가 다시 재요청(하나의처리 끝나고 다른페이지로 넘어갈때 사용)
		
		
//		request.setAttribute("list", dao.selectAll(deptId));
//		request.getRequestDispatcher("WEB-INF/jsp/emp/empList.jsp").forward(request, response);
	}
	
	
	

}
