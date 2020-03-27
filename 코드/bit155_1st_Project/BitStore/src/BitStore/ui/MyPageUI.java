package BitStore.ui;

import java.util.Scanner;

import BitStore.util.User;

public class MyPageUI {
	private Scanner sc = new Scanner(System.in);
	private User user;
	
	public MyPageUI() {
		user = new User();
	}

	// 관리자일 경우
	public void user() {
		while (true) {
			switch (userMenu()) {
			case 1: // 내정보확인
				user.myInfoUser();
				break;
			case 2: // 회원정보 수정
				user.updateUser();
				break;
			case 3: // 회원탈퇴
				user.quitUser();
				break;
			case 4: // 돌아가기
				LoginUI loginUI = new LoginUI();
				loginUI.user();
				break;
			case 0:
				quit();
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}
	}

	private void quit() {
		System.out.println("안녕히 가세요^^!");
		System.exit(0);
	}

	private int userMenu() {
		System.out.println("-----------------");
		System.out.println("1. 내정보 확인");
		System.out.println("2. 회원정보 수정");
		System.out.println("3. 회원탈퇴");
		System.out.println("4. 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
