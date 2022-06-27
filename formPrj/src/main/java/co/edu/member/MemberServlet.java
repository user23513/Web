package co.edu.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
    public MemberServlet() {
        super();
    }

    // get방식요청 : 조회
    // post방식요청 : 입력, 수정, 삭제
    
    // 서블릿 처리하는데 두가지 방식이 가능
    // 1) form => submit:페이지이동 (서블릿 => 화면.jsp)
    // 2) ajax => 한페이지에 머물면서 모든 처리를 함.(Single Page Application)
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//응답정보에 영문외의 언어가 있으면 처리.
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		Gson gson = new GsonBuilder().create(); // json 형태의 데이터 생성
		MemberDAO dao = new MemberDAO();
		
		if(cmd.equals("list")) {
			// db에서 전체 리스트를 가지고 와서 => json타입으로 화면에 보여주기.
			List<MemberVO> list = dao.memberList();
			
			//응답정보를 받아오는
			response.getWriter().print(gson.toJson(list));
			
		}else if(cmd.equals("insert")) {
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			MemberVO vo = new MemberVO();
			vo.setMembName(name);
			vo.setMembAddr(addr);
			
			dao.insertMember(vo);
			
			// {"retCode" : "Success"}
			response.getWriter().print(gson.toJson(vo));
			
		}else if(cmd.equals("update")) {
			// 14-전화번호
			String numb = request.getParameter("no");
			String phone = request.getParameter("ph");
			
			MemberVO vo = new MemberVO();
			vo.setMembNo(Integer.parseInt(numb)); //"14" => 14
			vo.setMembPhone(phone);
			
			if(dao.updateMember(vo)) {
				// {"retCode" : "Success"}
				response.getWriter().print("{\"retCode\" : \"Success\"}");
			}else {
				// {"retCode" : "Fail"}
				response.getWriter().print("{\"retCode\" : \"Fail\"}");
			}
			
			
		}else if(cmd.equals("delete")) {
			String delNo = request.getParameter("delNumber");
			
			if(dao.deleteMember(Integer.parseInt(delNo))) {
				response.getWriter().print("{\"retCode\" : \"Success\"}");
			}else {
				response.getWriter().print("{\"retCode\" : \"Fail\"}");
			}
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 처리.
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		// post 방식의 요청이 되면 실행 메소드
		
		String cmd = request.getParameter("cmd");
		
		String membName = request.getParameter("name");
		String membAddr = request.getParameter("addr");
		String membPhon = request.getParameter("phone");
		String membBirth = request.getParameter("birth");
		String membImag = request.getParameter("image");
		
		MemberVO vo = new MemberVO();
		vo.setMembName(membName);
		vo.setMembAddr(membAddr);
		vo.setMembPhone(membPhon);
		vo.setMembBirth(membBirth);
		vo.setMembImage(membImag);
		
		MemberDAO dao = new MemberDAO();
		
		Gson gson = new GsonBuilder().create();
		
		PrintWriter out = response.getWriter();
		
		// 입력, 수정, 삭제
		if(cmd.equals("add")) { // 입력
			dao.insertMember(vo);
			out.print(gson.toJson(vo));
			
		}else if(cmd.equals("modify")) { // 수정
			String mNo = request.getParameter("membNo");
			vo.setMembNo(Integer.parseInt(mNo));
			
			JsonObject obj = new JsonObject();
			if(dao.updateMember(vo)) {
				// {"membNo":"mNo", "membName":"membName","membAddr":"membAddr","membPhon":"membPhon", "membBirth":"membBirth","retCode":"Success"}
				// {"mno":?, "mName":?, "mAddr":?,...} => object
				//out.print("{\"retCode\" : \"Success\"}"); // json타입
				//out.print("{\"membNo\" : \""+mNo+"\" , \"membName\" : \""+membName+"\", \"membAddr\" : \""+membAddr+"\", \"membPhone\" : \""+membPhon+"\", \"membBirth\" : \""+membBirth+"\", \"retCode\": \" Success\"}");
				
				obj = new JsonObject(); // {"name":"홍길동", "age":20} 
				obj.addProperty("membNo", mNo); // {"membNo":20}
				obj.addProperty("membName", membName); //{"membNo":20,"membName":"홍길동"}
				obj.addProperty("membAddr", membAddr);
				obj.addProperty("membPhone", membPhon);
				obj.addProperty("membBirth", membBirth);
				obj.addProperty("retCode", "Success");
			}else {
				//out.print("{\"retCode\" : \"Fail\"}");
				
				obj.addProperty("retCode", "Fail");
			}
			out.print(gson.toJson(obj)); // 오브젝트타입을 json형태의 문자열로
			
		}else if(cmd.equals("remove")) { // 삭제
			String delNo = request.getParameter("delNo");
			if(dao.deleteMember(Integer.parseInt(delNo))) {
				out.print("{\"retCode\" : \"Success\"}");
			}else {
				out.print("{\"retCode\" : \"Fail\"}");
			}
			
		}
		
		
		
	}

}
