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
		String updateID = BitStore.currentLoginUser.getID();
		Iterator<String> mapIter = BitStore.userList.keySet().iterator();
		while (mapIter.hasNext()) {
			String key = mapIter.next();
			UserVO value = BitStore.userList.get(key);
			if (updateID.equals(key)) {
				System.out.println("[" + updateID + "]" + " 수정");
				System.out.print("비밀번호 : ");
				String pwd = in.nextLine();

				loop1: while (true) {
					Pattern pwPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$");
					Matcher matcher1 = pwPattern.matcher(pwd);
					if (!matcher1.matches()) {
						System.out.println("잘못 입력하셨습니다.");
						System.out.println("8~20자 사이의 영문 과 숫자,특수문자를 조합해 다시 입력해 주세요.");
						continue;
					} else {
						break loop1;
					}
				}

				System.out.print("이름 : ");
				String userName = in.nextLine();
				
				System.out.print("핸드폰 : ");
				String userPhone = in.nextLine();

				loop2: while (true) {
					Pattern phonePattern = Pattern.compile("^01([0|1|0]?)-?([0-9]{3,4})-?([0-9]{4})$");
					Matcher matcher1 = phonePattern.matcher(userPhone);
					if (!matcher1.matches()) {
						System.out.println("잘못 입력하셨습니다.");
						System.out.println("010-0000-0000 형식으로 입력해 주세요.");
						continue;
					} else {
						break loop2;
					}
				}

//				UserVO temp = new UserVO());
//				BitStore.userList.put(key, temp);
				BitStore.writeUserList();
				System.out.println(updateID + " 아이디 정보가 정상적으로 수정되었습니다.");
				return;
			}
		}
		System.out.println("찾는 아이디가 없습니다.");
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
