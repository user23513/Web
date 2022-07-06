package co.micol.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardUpdate")
public class BoardUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//단건조회
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.selectOne(id);
		
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/WEB-INF/jsp/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
