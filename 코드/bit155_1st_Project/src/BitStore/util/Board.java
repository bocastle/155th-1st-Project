package BitStore.util;

import java.util.Map;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String boardDate;
	
	public void insertBoard(Board board) {
	
	}
	
	public void writeBoardList() {
	
	}
	
	public boolean updateBoard(Board board) {
		return false;
	}
	
	public boolean deleteBoard(int boardNo) {
		return false;
	}
	
	public Map<Integer, Board> selectBoard() {
		return null;
	}
	
	public Board selectBoardByNo(int boardNo) {
		return null;
	}

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
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", boardDate=" + boardDate + "]";
	}
	
}
