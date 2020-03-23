package bitStore.board.vo;

public class BoardVO {
	int boardNo; //글번호
	String boardWriter; //글쓴이
	String boardTitle; //글제목
	String boardContent; //글내용
	String boardDate; //글등록날짜
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
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
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardWriter=" + boardWriter + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardDate=" + boardDate + "]";
	}
}
