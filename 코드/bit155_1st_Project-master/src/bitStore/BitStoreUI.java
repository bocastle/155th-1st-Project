package bitStore;

import java.util.Scanner;

import bitStore.login.ui.JoinUI;
import bitStore.login.ui.LoginUI;
import bitStore.login.util.LoginJoinUtil;

public class BitStoreUI {
	private LoginJoinUtil util = new LoginJoinUtil();
	private Scanner sc = new Scanner(System.in);
	public void service() {
		BaseUI ui = null;
		while (true) {
			switch (menu()) {
			case 1: ui = new JoinUI(util);   break;
			case 2: ui = new LoginUI(util); break;
			case 0: quit();
			}
			ui.service();
		}
	}

	private void quit() {
		System.out.println("안녕히 가세요.");
		System.exit(0);
	}

	private int menu() {
		System.out.println("-----------------");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
