package co.micol.prj.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;

@WebServlet("*.do") //모든 .do요청은 내가 처리한다.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<>(); //요청과 실행문을 매핑하기 위해   
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		//초기화하는 메서드(Mapping 하는 부분을 작성한다.)
		map.put("/main.do", new MainCommand()); //처음 접속하는 페이지
		
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//실행하는 메서드(서비스 해주는 것)
		request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지
		String uri = request.getRequestURI(); //요청된 URI를 확인한다.
		String contextPath = request.getContextPath(); //요청 URL로 부터 contextPath를 확인한다.
		String page = uri.substring(contextPath.length()); //실제 요청 페이지를 찾는다.
		
		Command command = map.get(page); //실제 수행할 Command를 찾음. new MainCommand();
		String viewPage = command.exec(request, response); //요청 Command를 수행하고 결과를 받음.
		
		// viewResolve
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp"; //시스템에서 접근 가능한 폴더를 더해주고 
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(viewPage); //.do로 권한 위임 처리
		}
	}

}
