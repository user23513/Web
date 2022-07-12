package co.micol.prj.notice.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImple.NoticeServiceImple;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//게시글 등록(파일 업로드 포함)
		NoticeService noticDao = new NoticeServiceImple();
		NoticeVO vo = new NoticeVO();
		
		String savePath = "C:\\Temp\\"; // 파일 저장위치(개발할때만 여기서쓴다.) /실제서버에서는 fileSave로 해줘야한다.
		int upLoadSize = 1024*1024*1024; // 최대 파일 사이즈 100MB까지 (http로 최대는 200MB)
		int n = 0;
		
		try { //multipart/form-data로 넘어올때는 MultipartRequest를 사용해야한다.
			MultipartRequest multi = new MultipartRequest(request, savePath, upLoadSize, "UTF-8", new DefaultFileRenamePolicy()); //이객체가 생성되면서 파일업로드는 끝남
			
			String originalFileName = multi.getOriginalFileName("file");
			String saveFileName = multi.getFilesystemName("file");
//			System.out.println("========================================");
//			System.out.println(originalFileName);
//			System.out.println(saveFileName);
			
			vo.setNoticeWriter(multi.getParameter("noticeWriter"));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeDate(Date.valueOf(multi.getParameter("noticeDate")));
			vo.setNoticeSubject(multi.getParameter("noticeSubject"));
			if(originalFileName != null) {
				vo.setNoticeAttech(originalFileName);
				saveFileName = savePath + saveFileName; //파일경로를 추가한다.
				vo.setNoticeAttechDir(saveFileName);
			}
			
			n = noticDao.noticeInsert(vo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String returnPage = null;
		if(n != 0) {
			returnPage = "noticeList.do";
		}else {
			request.setAttribute("message", "게시글 등록이 실패했습니다!");
			returnPage = "notice/noticeError";
		}
		return returnPage;
	}

}
