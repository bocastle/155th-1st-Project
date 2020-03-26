package BitStore.util;

import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BitStore.domain.UserVO;

public class User {

	Scanner in = new Scanner(System.in);

	public void selectUser() {
		System.out.println("[회원목록 조회]");
		Iterator<String> mapIter = BitStore.userList.keySet().iterator();
		while (mapIter.hasNext()) {
			String key = mapIter.next();
			UserVO value = BitStore.userList.get(key);
			System.out.println(value + " / ");
		}
	}

	public void selectUserByID() {
		System.out.print("상세조회할 아이디를 입력하세요. : ");
		String selectID = in.nextLine();
		Iterator<String> mapIter = BitStore.userList.keySet().iterator();
		while (mapIter.hasNext()) {
			String key = mapIter.next();
			UserVO value = BitStore.userList.get(key);
			if (selectID.equals(key)) {
				System.out.println(value);
				return;
			}
		}
		System.out.println("찾는 아이디가 없습니다.");
	}

	public void updateUser() {
		
	}

	public void deleteUser() {
		System.out.print("삭제할 아이디를 입력하세요. : ");
		String deleteID = in.nextLine();
		Iterator<String> mapIter = BitStore.userList.keySet().iterator();
		while (mapIter.hasNext()) {
			String key = mapIter.next();
			UserVO value = BitStore.userList.get(key);
			if (deleteID.equals(key)) {
				BitStore.userList.remove(key);
				System.out.println(key + " 아이디가 정상적으로 삭제되었습니다.");
				BitStore.writeUserList();
				return;
			}
		}
		System.out.println("삭제할 아이디가 없습니다.");
	}

}
