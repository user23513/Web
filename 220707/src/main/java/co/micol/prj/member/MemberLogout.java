package co.micol.prj.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;

public class MemberLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그아웃
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name"); //세션객체에 담아둔 name값을 가져온다.
		request.setAttribute("message", name+"님 정상적으로 로그아웃 처리 되었습니다!!");
		session.invalidate(); //세션을 서버에서 완전히 삭제
		return "member/memberLogout";
	}

}
