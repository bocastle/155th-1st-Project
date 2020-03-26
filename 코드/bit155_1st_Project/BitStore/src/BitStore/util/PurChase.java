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
		System.out.print("현재 남은 포인트 : ");
		System.out.println(BitStore.currentLoginUser.getUserPoint());
	}

	public void discountProduct() {
		if (basket.size() != 0) {
			for (int i = 0; i < basket.size(); i++) {
				totalPrice += basket.get(i).getPrice();
			}
		}
		System.out.println("총 " + totalPrice + "원 입니다.");
		if (BitStore.currentLoginUser.isDiscount() == true) {
			totalPrice = (int) (totalPrice * 0.9);
			System.out.println("할인이 적용되어 총 " + totalPrice + "원입니다.");
		} else {
			System.out.println("할인을 받으실 수 없는 상태이십니다..");
		}
		dcFlag = true;
	}

	public void insertBasket() {
		System.out.println("장바구니에 담을 상품번호를 입력하세요,");
		int productNo = in.nextInt();
		Iterator<Integer> mapIter = BitStore.productList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			ProductVO value = BitStore.productList.get(key);
			for (int i = 0; i < basket.size(); i++) {
				if (productNo == basket.get(i).getProductNo()) {
					System.out.println("이미 장바구니에 등록된 상품입니다.");
					return;
				}
			}
			if (productNo == value.getProductNo()) {
				basket.add(value);
				System.out.println(value.getProductNo() + ", " + value.getProductName() + " 상품이 추가되었습니다.");
				return;
			}
		} // while_end
		System.out.println("찾는 상품이 없습니다.");
	}
	
	public void deleteBasket() {
		System.out.println("장바구니에서 뺄 상품번호를 입력하세요,");
		int productNo = in.nextInt();
		Iterator<Integer> mapIter = BitStore.productList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			ProductVO value = BitStore.productList.get(key);
			if (productNo == value.getProductNo()) {
				basket.remove(value);
				System.out.println(value.getProductNo() + ", " + value.getProductName() + " 상품이 빠졌습니다.");
				return;
			}
		} // while_end
		System.out.println("찾는 상품이 없습니다.");
	}

	public void selectBasket() {
		System.out.println("장바구니 목록");
		if (basket.size() != 0) {
			for (int i = 0; i < basket.size(); i++) {
				System.out.println(basket.get(i).toString());
			}
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}

	}

}
