package bitStore;

import java.util.Scanner;

import bitStore.user.dao.UserJoinLoginDAO;
import bitStore.user.ui.UserBaseUI;
import bitStore.user.ui.UserJoinUI;
import bitStore.user.ui.UserLoginUI;

public class BitStoreUI {
	private UserJoinLoginDAO dao = new UserJoinLoginDAO();
	private Scanner sc = new Scanner(System.in);
	public void service() {
		UserBaseUI ui = null;
		while (true) {
			switch (menu()) {
			case 1: ui = new UserJoinUI(dao);   break;
			case 2: ui = new UserLoginUI(dao); break;
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
