package co.micol.prj.emp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/EmpListServ", "/empList"}) // DB처리담당 / jsp에서 출력담당
public class EmpListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpListServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		String id = request.getParameter("departmentId");
		if(id != null && ! id.isEmpty()) {
			request.setAttribute("select", list.add(dao.selectOne(id)));
		}else {
			request.setAttribute("list", dao.selectAll(id));
		}
		request.getRequestDispatcher("WEB-INF/jsp/emp/empList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
