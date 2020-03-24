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
		System.out.println("�ȳ��� ������.");
		System.exit(0);
	}

	private int menu() {
		System.out.println("-----------------");
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
		System.out.println("0. ����");
		System.out.println("-----------------");
		System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}
}
