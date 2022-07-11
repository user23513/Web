package co.micol.prj.notice.vo;

import java.sql.Date; //시분초가 필요하면 util.Date쓰고 필요없으면 sql.Date쓴다

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private Date noticeDate;
	private int noticeHit;
	private String noticeAttech; //실제 파일명
	private String noticeAttechDir; //파일이 존재하는 물리적위치
}
