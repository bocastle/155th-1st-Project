package Mar23_Quiz_Book;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//도서 관리자 클래스

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BookManager {

	Scanner scan = new Scanner(System.in);
	HashMap<String, Book> book_dic = new HashMap<String, Book>();

	//book.txt 로딩
	public BookManager() {
		File file = new File("book.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		if (file.exists()) { //book.txt 파일이 존재하면 값을 읽어와서 HashMap에 저장
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				ois = new ObjectInputStream(fis);
				book_dic = (HashMap) ois.readObject();
			} catch (Exception e) {
				System.out.println("불러오는데 실패하였습니다.");
				e.printStackTrace();
			} finally {
				try {
					ois.close();
					bis.close();
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Run() {
		int key = 0;
		while ((key = selectMenu()) != 0) {
			switch (key) {
			case 1:
				addBook();
				break;
			case 2:
				removeBook();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				listBook();
				break;
			case 5:
				listISBN();
				break;
			case 6:
				save();
				break;
			case 7:
				load();
				break;
			default:
				System.out.println("잘못 선택하였습니다.");
				break;
			}
		}
		System.out.println("종료합니다...");
	}
	
	//추가★★★★★★★★★★★★★★★★★★
	void save() {
		File file = new File("book.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(book_dic);

		} catch (Exception e) {
			System.out.println("에러발생!!!");
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
		System.out.println("저장되었습니다.");

	}
	
	//추가★★★★★★★★★★★★★★★★★★
	void load() {
		File file = new File("book.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);

			book_dic = (HashMap) ois.readObject();

			Set<String> set = book_dic.keySet();
			System.out.println("ISBN\t제목\t가격");
			for (String sen : set) {
				String isbn = book_dic.get(sen).getIsbn();
				String title = book_dic.get(sen).getTitle();
				int price = book_dic.get(sen).getPrice();
				System.out.printf("[%s]\t%.2s\t%d원\n", isbn, title, price);
			}
		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	int selectMenu() {
		System.out.println("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록 6:저장 7:불러오기 0:종료");
		int key = scan.nextInt();
		scan.nextLine();
		return key;
	}

	void addBook() {
		String isbn;
		System.out.print("추가할 도서 ISBN:");
		isbn = scan.nextLine();
		if (book_dic.containsKey(isbn)) {
			System.out.println("이미 존재하는 ISBN입니다.");
			return;
		}

		String title;
		int price;
		System.out.print("도서 제목:");
		title = scan.nextLine();
		System.out.print("가격:");
		price = scan.nextInt();
		scan.nextLine();
		Book book = new Book(isbn, title, price);
		book_dic.put(isbn, book);
		System.out.println(book.toString() + " 생성하였습니다.");
	}

	void removeBook() {
		String isbn;
		System.out.print("삭제할 도서 ISBN:");
		isbn = scan.nextLine();
		if (book_dic.containsKey(isbn)) {
			book_dic.remove(isbn);
			System.out.println("삭제하였습니다.");
		} else {
			System.out.println("존재하지 않습니다.");
		}
	}

	void searchBook() {
		String isbn;
		System.out.print("검색할 도서 ISBN:");
		isbn = scan.nextLine();
		if (book_dic.containsKey(isbn)) {
			Book book = book_dic.get(isbn);
			System.out.println("검색 결과>>" + book.toString());
		} else {
			System.out.println("존재하지 않습니다.");
		}
	}

	void listBook() {
		System.out.println("도서 목록");
		int cnt = book_dic.size();
		System.out.println("도서 수:" + cnt);
		for (Book book : book_dic.values()) {
			System.out.println(book.toString());
		}
	}

	void listISBN() {
		System.out.println("ISBN 목록");
		int cnt = book_dic.size();
		System.out.println("도서 수:" + cnt);
		for (String isbn : book_dic.keySet()) {
			System.out.println(isbn);
		}
	}


}