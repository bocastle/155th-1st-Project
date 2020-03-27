package BitStore.ui;

import java.util.Scanner;

import BitStore.util.User;

public class MyPageUI {
	private Scanner sc = new Scanner(System.in);
	private User user;
	
	public MyPageUI() {
		user = new User();
	}

	// �������� ���
	public void user() {
		while (true) {
			switch (userMenu()) {
			case 1: // ������Ȯ��
				user.myInfoUser();
				break;
			case 2: // ȸ������ ����
				user.updateUser();
				break;
			case 3: // ȸ��Ż��
				user.quitUser();
				break;
			case 4: // ���ư���
				LoginUI loginUI = new LoginUI();
				loginUI.user();
				break;
			case 0:
				quit();
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	private void quit() {
		System.out.println("�ȳ��� ������^^!");
		System.exit(0);
	}

	private int userMenu() {
		System.out.println("-----------------");
		System.out.println("1. ������ Ȯ��");
		System.out.println("2. ȸ������ ����");
		System.out.println("3. ȸ��Ż��");
		System.out.println("4. ���ư���");
		System.out.println("0. ����");
		System.out.println("-----------------");
		System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}
}
