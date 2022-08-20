package co.sohyoen.reply.vo;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {

	private int commentNo;
	private String commentWriter; // 댓글 작성자
	private String commentContent; // 댓글 내용
	private String commentDate; // 댓글 작성일자
	private int NoticeVO;

	
	
}
