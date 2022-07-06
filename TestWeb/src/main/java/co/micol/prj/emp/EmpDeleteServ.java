package co.micol.prj.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empDelete")
public class EmpDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpDeleteServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		EmpDAO dao = new EmpDAO();
		String empId = request.getParameter("empId");
		int r = dao.empDelete(empId);
		
		response.getWriter()
				.append("<script>")
				.append("alert('"+ r +"건이 삭제됨');")
				.append("location.href='empList';")
				.append("</script>");
		
//		request.setAttribute("msg", r + "건 삭제됨");
//		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
