package BitStore.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

import BitStore.domain.BoardVO;
import BitStore.domain.UserVO;

public class Board {
	private Scanner in = new Scanner(System.in);
	private int count;
	private SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
	private Date date = new Date();
	private boolean flag = false;

	public void selectBoard() {
		Iterator<Integer> mapIter = BitStore.boardList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			BoardVO value = BitStore.boardList.get(key);
			System.out.println(value + " / ");
		}
	}

	public void selectBoardByNo() {
		System.out.print("상세조회할 게시글 번호를 입력하세요. : ");
		int selectID = Integer.parseInt(in.nextLine());
		Iterator<Integer> mapIter = BitStore.boardList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			BoardVO value = BitStore.boardList.get(key);
			if (selectID == key) {
				System.out.println(value);
				return;
			}
		}
		System.out.println("찾는 게시글이 없습니다.");
	}

	// 게시글 번호, 제목, 글쓴이, 날짜, 내용
	public void insertBoard() {

		Iterator<Integer> mapIter = BitStore.boardList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			BoardVO value = BitStore.boardList.get(key);
			count = BitStore.boardList.get(key).getBoardNo();
		}

		BoardVO boardvo = new BoardVO();
		boardvo.setBoardNo(++count);
		System.out.print("제목: ");
		boardvo.setBoardTitle(in.nextLine());
		System.out.print("내용: ");
		boardvo.setBoardContent(in.nextLine());
		System.out.print("글쓴이: ");
		boardvo.setBoardWriter(BitStore.currentLoginUser.getID());
		boardvo.setBoardDate(dt.format(date));
		BitStore.boardList.put(count, boardvo);
		writeBoardList();
	}

	public void writeBoardList() {
		// 저장을 마지막
		File file = new File("boardList.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(BitStore.boardList);
		} catch (Exception e) {
			System.out.println("게시판목록 저장에 실패하였습니다.");
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void updateBoard() {
		System.out.println("수정할 게시글 번호를 입력하세요");
		int updateNum = Integer.parseInt(in.nextLine());
		Iterator<Integer> mapIter = BitStore.boardList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			BoardVO value = BitStore.boardList.get(key);
			if (key == updateNum) {
				flag = true;
				System.out.println("수정할 제목을 입력하세요 : ");
				BitStore.boardList.get(key).setBoardTitle(in.nextLine());
				System.out.println("수정할 내용을 입력하세요 : ");
				BitStore.boardList.get(key).setBoardContent(in.nextLine());
				System.out.println("수정이 완료 되었습니다.");
				return;
			}
		}
		if (flag == false) {
			System.out.println("입력한 글번호는 존재하지 않습니다.");
		}
		writeBoardList();
	}

	public void deleteBoard() {
		System.out.println("삭제할 글 번호를 입력하세요 : ");
		int deleteNum = Integer.parseInt(in.nextLine());
		Iterator<Integer> mapIter = BitStore.boardList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			BoardVO value = BitStore.boardList.get(key);
			if (deleteNum == key) {
				BitStore.userList.remove(key);
				System.out.println(key + " 아이디가 정상적으로 삭제되었습니다.");
//				BitStore.writeUserList();
				return;
			}
		}
		System.out.println("삭제할 아이디가 없습니다.");
		writeBoardList();
	}
}
