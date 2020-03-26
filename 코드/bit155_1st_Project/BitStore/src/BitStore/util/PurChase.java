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

	public void selectPoint() {
		System.out.print("현재 남은 포인트 : ");
		System.out.println(BitStore.currentLoginUser.getUserPoint());
	}

	public void discountProduct() {

	}

	public void insertBasket() {
		BitStoreUI bitStoreUI = new BitStoreUI();
		while (true) {
			System.out.println("장바구니에 담을 상품번호를 입력하세요,");
			int productNo = in.nextInt();
			Iterator<Integer> mapIter = BitStore.productList.keySet().iterator();
			int key = mapIter.next();
			ProductVO value = BitStore.productList.get(key);
			if (productNo == value.getProductNo()) {
				basket.add(value);
				System.out.println(value.getProductNo() + ", " + value.getProductName() + "상품이 추가되었습니다.");
			}
			System.out.println("찾는 상품이 없습니다.");
		}

	}

	public void selectBasket() {
		if (basket.size() != 0) {
			for (int i = 0; i < basket.size(); i++) {
				System.out.println(basket.get(i).toString());
			}
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}

	}

}
