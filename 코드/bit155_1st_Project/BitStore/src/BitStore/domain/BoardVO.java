package BitStore.domain;

import java.io.Serializable;

public class BoardVO implements Serializable{
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String boardDate;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	@Override
	public String toString() {
		return "번호 : " + this.boardNo + ", 제목 : " + boardTitle + ", "
				+ "내용 : " + boardContent
				+ ", 글쓴이 : " + boardWriter + ", 날짜 : =" + boardDate;
	}
	
}