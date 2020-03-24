package Mar23_Quiz_Book;

import java.io.Serializable;

//���� Ŭ����

public class Book implements Serializable{

	final String isbn;
	String title;
	int price;

	public Book(String isbn, String title, int price) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	public String ISBN() {
		return isbn;
	}

	public String toString() {
		return String.format("ISBN:%s �̸�:%s ����:%d", isbn, title, price);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	
	
}
