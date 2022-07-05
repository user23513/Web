package co.micol.prj.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeptInsert")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeptInsertServ() {
        super();
    }

    // 등록페이지 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptInsert.jsp").forward(request, response);
		
	}

	// DB 등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 파라미터를 VO에 담고
		String id = request.getParameter("deptId");
		String name = request.getParameter("deptName");
		String manager = request.getParameter("deptManagerId");
		String location = request.getParameter("deptLocationId");
		
		DeptVO vo = new DeptVO();
		vo.setDeptId(id);
		vo.setDeptName(name);
		vo.setDeptManagerId(manager);
		vo.setDeptLocationId(location);
		
		// DB처리
		DeptDAO dao = new DeptDAO();
		int cnt = dao.deptInsert(vo);
		
		// 결과출력
		response.getWriter()
				.append(cnt + "건이 등록됨");
				
		
	}

}
