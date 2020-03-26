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
		System.out.println("[ȸ����� ��ȸ]");
		Iterator<String> mapIter = BitStore.userList.keySet().iterator();
		while (mapIter.hasNext()) {
			String key = mapIter.next();
			UserVO value = BitStore.userList.get(key);
			System.out.println(value + " / ");
		}
	}

	public void selectUserByID() {
		System.out.print("����ȸ�� ���̵� �Է��ϼ���. : ");
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
		System.out.println("ã�� ���̵� �����ϴ�.");
	}

	public void updateUser() {
		String updateID = BitStore.currentLoginUser.getID();
		Iterator<String> mapIter = BitStore.userList.keySet().iterator();
		while (mapIter.hasNext()) {
			String key = mapIter.next();
			UserVO value = BitStore.userList.get(key);
			if (updateID.equals(key)) {
				System.out.println("[" + updateID + "]" + " ����");
				System.out.print("��й�ȣ : ");
				String pwd = in.nextLine();

				loop1: while (true) {
					Pattern pwPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$");
					Matcher matcher1 = pwPattern.matcher(pwd);
					if (!matcher1.matches()) {
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						System.out.println("8~20�� ������ ���� �� ����,Ư�����ڸ� ������ �ٽ� �Է��� �ּ���.");
						continue;
					} else {
						break loop1;
					}
				}

				System.out.print("�̸� : ");
				String userName = in.nextLine();
				
				System.out.print("�ڵ��� : ");
				String userPhone = in.nextLine();

				loop2: while (true) {
					Pattern phonePattern = Pattern.compile("^01([0|1|0]?)-?([0-9]{3,4})-?([0-9]{4})$");
					Matcher matcher1 = phonePattern.matcher(userPhone);
					if (!matcher1.matches()) {
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						System.out.println("010-0000-0000 �������� �Է��� �ּ���.");
						continue;
					} else {
						break loop2;
					}
				}

//				UserVO temp = new UserVO());
//				BitStore.userList.put(key, temp);
				BitStore.writeUserList();
				System.out.println(updateID + " ���̵� ������ ���������� �����Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("ã�� ���̵� �����ϴ�.");
	}

	public void deleteUser() {
		System.out.print("������ ���̵� �Է��ϼ���. : ");
		String deleteID = in.nextLine();
		Iterator<String> mapIter = BitStore.userList.keySet().iterator();
		while (mapIter.hasNext()) {
			String key = mapIter.next();
			UserVO value = BitStore.userList.get(key);
			if (deleteID.equals(key)) {
				BitStore.userList.remove(key);
				System.out.println(key + " ���̵� ���������� �����Ǿ����ϴ�.");
				BitStore.writeUserList();
				return;
			}
		}
		System.out.println("������ ���̵� �����ϴ�.");
	}

}
