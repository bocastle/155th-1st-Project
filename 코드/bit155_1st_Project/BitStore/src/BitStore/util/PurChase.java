package BitStore.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import BitStore.domain.BoardVO;
import BitStore.domain.ProductVO;
import BitStore.ui.user.BitStoreUI;

public class PurChase {
	private Scanner in = new Scanner(System.in);
	public static List<ProductVO> basket = new ArrayList();
	public static int totalPrice = 0;
	public static boolean dcFlag = false;

	public void selectPoint() {
		System.out.print("���� ���� ����Ʈ : ");
		System.out.println(BitStore.currentLoginUser.getUserPoint());
	}

	public void discountProduct() {
		if (basket.size() != 0) {
			for (int i = 0; i < basket.size(); i++) {
				totalPrice += basket.get(i).getPrice();
			}
		}
		System.out.println("�� " + totalPrice + "�� �Դϴ�.");
		if (BitStore.currentLoginUser.isDiscount() == true) {
			totalPrice = (int) (totalPrice * 0.9);
			System.out.println("������ ����Ǿ� �� " + totalPrice + "���Դϴ�.");
		} else {
			System.out.println("������ ������ �� ���� �����̽ʴϴ�..");
		}
		dcFlag = true;
	}

	public void insertBasket() {
		System.out.println("��ٱ��Ͽ� ���� ��ǰ��ȣ�� �Է��ϼ���,");
		int productNo = in.nextInt();
		Iterator<Integer> mapIter = BitStore.productList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			ProductVO value = BitStore.productList.get(key);
			for (int i = 0; i < basket.size(); i++) {
				if (productNo == basket.get(i).getProductNo()) {
					System.out.println("�̹� ��ٱ��Ͽ� ��ϵ� ��ǰ�Դϴ�.");
					return;
				}
			}
			if (productNo == value.getProductNo()) {
				basket.add(value);
				System.out.println(value.getProductNo() + ", " + value.getProductName() + " ��ǰ�� �߰��Ǿ����ϴ�.");
				return;
			}
		} // while_end
		System.out.println("ã�� ��ǰ�� �����ϴ�.");
	}
	
	public void deleteBasket() {
		System.out.println("��ٱ��Ͽ��� �� ��ǰ��ȣ�� �Է��ϼ���,");
		int productNo = in.nextInt();
		Iterator<Integer> mapIter = BitStore.productList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			ProductVO value = BitStore.productList.get(key);
			if (productNo == value.getProductNo()) {
				basket.remove(value);
				System.out.println(value.getProductNo() + ", " + value.getProductName() + " ��ǰ�� �������ϴ�.");
				return;
			}
		} // while_end
		System.out.println("ã�� ��ǰ�� �����ϴ�.");
	}

	public void selectBasket() {
		System.out.println("��ٱ��� ���");
		if (basket.size() != 0) {
			for (int i = 0; i < basket.size(); i++) {
				System.out.println(basket.get(i).toString());
			}
		} else {
			System.out.println("��ٱ��ϰ� ����ֽ��ϴ�.");
		}

	}

}
