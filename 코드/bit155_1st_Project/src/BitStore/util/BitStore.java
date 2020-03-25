package BitStore.util;

import java.util.Map;

public class BitStore {
	public static Map<String, User> userList;
	public static Map<Integer, Product> productList;
	public static Map<Integer, Product> discardProductList;
	public static Map<Integer, Board> boardList;
	public static User currentLoginUser;
	
	public void join() {
	
	}
	
	public boolean checkID(String ID) {
		return false;
	}
	
	public boolean checkPwd(String pwd) {
		return false;
	}
	
	public boolean checkPhone(String userPhone) {
		return false;
	}
	
	public void writeUserList() {
	
	}
	
	public void login() {
	
	}
	
	public void logout() {
	
	}
	
	public String findID(String userName, String userPhone) {
		return "ID";
	}
	
	public String findPwd(String ID, String userName) {
		return "pwd";
	}
	
	public void readUserList() {
	
	}
	
	public void readProductList() {
	
	}
	
	public void readDiscardProductList() {
	
	}
	
	public void readBoardList() {
	
	}
}
