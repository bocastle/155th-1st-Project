package BitStore.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BitStore.domain.BoardVO;
import BitStore.domain.ProductVO;
import BitStore.domain.UserVO;

public class BitStore {
	public static Map<String, UserVO> userList = new HashMap();
	public static Map<Integer, ProductVO> productList = new HashMap();
	public static Map<Integer, ProductVO> discardProductList = new HashMap();
	public static Map<Integer, BoardVO> boardList = new HashMap();
	public static User currentLoginUser = new User();
	Scanner in;

	public BitStore() {
		initSaveAdmin(); //admin 계정 추가
		readUserList(); // 회원목록 파일 불러오기
//		readProductList(); // 상품목록 파일 불러오기
//		readDiscardProductList(); // 폐기상품목록 파일 불러오기
//		readBoardList(); // 게시판목록 파일 불러오기
		in = new Scanner(System.in);
	}

	public void join() {
	}
	
	public void login() {
		System.out.println("아이디 입력해주세요.");
	}

	public void checkID() {
	}

	public void checkPwd() {
	}

	public void checkPhone() {
	}
	
	public void initUserList() {
		
	}
	
	public void initSaveAdmin() {
		Map<String, UserVO> userListAdminTemp = new HashMap();
		userListAdminTemp.put("admin", new UserVO("admin","admin","admin","010-2316-0200",0,0,false,null));
		userList = userListAdminTemp;
		File file = new File("userList.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
		} catch (Exception e) {
			System.out.println("회원목록 저장에 실패하였습니다.");
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

	public void writeUserList() {
		File file = new File("userList.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
		} catch (Exception e) {
			System.out.println("회원목록 저장에 실패하였습니다.");
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

	public void logout() {

	}

	public String findID(String userName, String userPhone) {
		return "ID";
	}

	public String findPwd(String ID, String userName) {
		return "pwd";
	}

	public void readUserList() {
		File file = new File("userList.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			userList = (HashMap) ois.readObject();
			System.out.println(userList.toString());
		} catch (Exception e) {
			System.out.println("회원목록을 불러오는데 실패하였습니다.");
			e.printStackTrace();
		} finally {
			this.close(fis, bis, ois);
		}
	}

	public void readProductList() {
		File file = new File("productList.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			productList = (HashMap) ois.readObject();
		} catch (Exception e) {
			System.out.println("상품목록을 불러오는데 실패하였습니다.");
			e.printStackTrace();
		} finally {
			this.close(fis, bis, ois);
		}
	}

	public void readDiscardProductList() {
		File file = new File("productList.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			discardProductList = (HashMap) ois.readObject();
		} catch (Exception e) {
			System.out.println("폐기상품목록을 불러오는데 실패하였습니다.");
			e.printStackTrace();
		} finally {
			this.close(fis, bis, ois);
		}
	}

	public void readBoardList() {
		File file = new File("productList.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			boardList = (HashMap) ois.readObject();
		} catch (Exception e) {
			System.out.println("게시판목록을 불러오는데 실패하였습니다.");
			e.printStackTrace();
		} finally {
			this.close(fis, bis, ois);
		}
	}

	public void close(FileInputStream fis, BufferedInputStream bis, ObjectInputStream ois) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (bis != null) {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
