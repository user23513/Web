package co.micol.prj.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpUpdate")
public class EmpUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpUpdateServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("emp", new EmpDAO().empUpdate());
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
