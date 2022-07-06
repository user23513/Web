package co.micol.prj.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardInsert")
public class BoardInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/board/boardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String rdt = request.getParameter("rdt");
		String hit = request.getParameter("hit");
		
		BoardVO vo = new BoardVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setRdt(rdt);
		vo.setHit(hit);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.insert(vo);
		
		//response.getWriter().append(cnt + "건 입력");
		response.sendRedirect("boardList");
		
		
	}

}
