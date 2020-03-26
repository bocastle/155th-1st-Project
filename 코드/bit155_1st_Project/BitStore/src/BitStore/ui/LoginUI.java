package BitStore.ui;

import java.util.Scanner;

import BitStore.ui.admin.MemberUI;
import BitStore.ui.admin.ProductUI;
import BitStore.ui.user.BitStoreUI;
import BitStore.ui.user.UserUI;
import BitStore.util.BitStore;
import BitStore.util.User;

public class LoginUI {
	private Scanner sc;
	private BitStoreUI bitstoreUI;
	private UserUI userUI;

	public LoginUI() {
		sc = new Scanner(System.in);
		bitstoreUI = new BitStoreUI(); // ����� - ������ �̿�
		userUI = new UserUI(); // ���� - �α���
	}

	// �������� ���
	public void admin() {
		while (true) {
			switch (adminMenu()) {
			case 1: // ȸ�� ����
				MemberUI memberUI = new MemberUI();
				memberUI.admin();
				break;
			case 2: // ��ǰ ����
				ProductUI productUI = new ProductUI();
				productUI.admin();
				break;
			case 3: // �Խ���
				BoardUI boardUI = new BoardUI();
				boardUI.commonBoard();
				break;
			case 4: // �α׾ƿ�
				BitStore bitstore = new BitStore();
				bitstore.logout();
//				userUI.service();
				// �α׾ƿ��� BitStore�� �ִ� currentLoginUser null�� �ʱ�ȭ �߰�
			case 0:
				quit();
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	// ������� ���
	public void user() {
		while (true) {
			switch (userMenu()) {
			case 1: // ������ �̿�
				bitstoreUI.useBitStore();
				break;
			case 2: // �Խ���
				BoardUI boardUI = new BoardUI();
				boardUI.commonBoard();
				break;
			case 3: // ȸ������ ����
				User user2 = new User();
				user2.updateUser();
				break;
			case 4: // �α׾ƿ�
				BitStore bitstore = new BitStore();
				bitstore.logout();
//				userUI.service();
				// �α׾ƿ��� BitStore�� �ִ� currentLoginUser null�� �ʱ�ȭ �߰�
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

	private int adminMenu() {
		System.out.println("-----------------");
		System.out.println("1. ȸ������");
		System.out.println("2. ��ǰ����");
		System.out.println("3. �Խ���");
		System.out.println("4. �α׾ƿ�");
		System.out.println("0. ����");
		System.out.println("-----------------");
		System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}

	private int userMenu() {
		System.out.println("-----------------");
		System.out.println("1. ������ �̿�");
		System.out.println("2. �Խ���");
		System.out.println("3. ȸ������ ����");
		System.out.println("4. �α׾ƿ�");
		System.out.println("0. ����");
		System.out.println("-----------------");
		System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}
}
