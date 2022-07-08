package co.micol.prj.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//ajax를 이용한 아이디 중복체크
		MemberService memberDAO = new MemberServiceImpl();
		String id = request.getParameter("id");
		boolean b = memberDAO.isMemberIdCheck(id); // true: 사용가능
		String result = "Used";
		if(!b) {
			result="Un Used";
		}
		
		return "ajax:"+result; //결과가 ajax호출이라는 걸 viewResolve에게 알려주기 위해 
	}

}
