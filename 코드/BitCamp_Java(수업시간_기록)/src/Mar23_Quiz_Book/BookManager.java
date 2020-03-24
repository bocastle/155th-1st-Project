package Mar23_Quiz_Book;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//���� ������ Ŭ����

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BookManager {

	Scanner scan = new Scanner(System.in);
	HashMap<String, Book> book_dic = new HashMap<String, Book>();

	//book.txt �ε�
	public BookManager() {
		File file = new File("book.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		if (file.exists()) { //book.txt ������ �����ϸ� ���� �о�ͼ� HashMap�� ����
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				ois = new ObjectInputStream(fis);
				book_dic = (HashMap) ois.readObject();
			} catch (Exception e) {
				System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
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
				System.out.println("�߸� �����Ͽ����ϴ�.");
				break;
			}
		}
		System.out.println("�����մϴ�...");
	}
	
	//�߰��ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
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
			System.out.println("�����߻�!!!");
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
		System.out.println("����Ǿ����ϴ�.");

	}
	
	//�߰��ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
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
			System.out.println("ISBN\t����\t����");
			for (String sen : set) {
				String isbn = book_dic.get(sen).getIsbn();
				String title = book_dic.get(sen).getTitle();
				int price = book_dic.get(sen).getPrice();
				System.out.printf("[%s]\t%.2s\t%d��\n", isbn, title, price);
			}
		} catch (Exception e) {
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
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
		System.out.println("1:�߰� 2:���� 3:�˻� 4:���� ��� 5:ISBN ��� 6:���� 7:�ҷ����� 0:����");
		int key = scan.nextInt();
		scan.nextLine();
		return key;
	}

	void addBook() {
		String isbn;
		System.out.print("�߰��� ���� ISBN:");
		isbn = scan.nextLine();
		if (book_dic.containsKey(isbn)) {
			System.out.println("�̹� �����ϴ� ISBN�Դϴ�.");
			return;
		}

		String title;
		int price;
		System.out.print("���� ����:");
		title = scan.nextLine();
		System.out.print("����:");
		price = scan.nextInt();
		scan.nextLine();
		Book book = new Book(isbn, title, price);
		book_dic.put(isbn, book);
		System.out.println(book.toString() + " �����Ͽ����ϴ�.");
	}

	void removeBook() {
		String isbn;
		System.out.print("������ ���� ISBN:");
		isbn = scan.nextLine();
		if (book_dic.containsKey(isbn)) {
			book_dic.remove(isbn);
			System.out.println("�����Ͽ����ϴ�.");
		} else {
			System.out.println("�������� �ʽ��ϴ�.");
		}
	}

	void searchBook() {
		String isbn;
		System.out.print("�˻��� ���� ISBN:");
		isbn = scan.nextLine();
		if (book_dic.containsKey(isbn)) {
			Book book = book_dic.get(isbn);
			System.out.println("�˻� ���>>" + book.toString());
		} else {
			System.out.println("�������� �ʽ��ϴ�.");
		}
	}

	void listBook() {
		System.out.println("���� ���");
		int cnt = book_dic.size();
		System.out.println("���� ��:" + cnt);
		for (Book book : book_dic.values()) {
			System.out.println(book.toString());
		}
	}

	void listISBN() {
		System.out.println("ISBN ���");
		int cnt = book_dic.size();
		System.out.println("���� ��:" + cnt);
		for (String isbn : book_dic.keySet()) {
			System.out.println(isbn);
		}
	}


}