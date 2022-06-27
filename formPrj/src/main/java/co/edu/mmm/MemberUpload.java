package co.edu.mmm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet({ "/memberUpload", "/fileUpload" })
public class MemberUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String file = request.getServletContext().getRealPath("images");
		int fileSize = 5 * 1023 * 1024; // 5메가까지 올리도록 하겠다.
		MultipartRequest mr = new MultipartRequest(request // 요청정보
				, file // 파일이름
				, fileSize // 파일사이즈
				, "utf-8" // 인코딩타입
				, new DefaultFileRenamePolicy()// 리네임 정책
				); // 이객체를 생성해주면 알아서 파일이 올라가는게 cos.jar
		String mn = mr.getParameter("membName");
		String ph = mr.getContentType("phone");
		String ad = mr.getContentType("address");
		String bi = mr.getContentType("birth");
		String im = mr.getContentType("image");
		im = mr.getFilesystemName("image"); // 같은 이름의 이미지가 있을수있으니? 바뀐이름으로 db에 저장하겠습니다.
		
		MemberVO vo = new MemberVO();
		vo.setMembName(mn);
		vo.setMembPhone(ph);
		vo.setMembAddr(ad);
		vo.setMembBirth(bi);
		vo.setMembImage(im);
		
		MemberDAO dao = new MemberDAO();
		Gson gson = new GsonBuilder().create();
		PrintWriter out = response.getWriter();
		
		dao.insertMember(vo);
		
		
		
	}

}
