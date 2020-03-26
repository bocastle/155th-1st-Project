package BitStore.ui.user;

import java.util.Scanner;

import BitStore.Interface.CashPayMentImpl;
import BitStore.Interface.PayMent;
import BitStore.Interface.PointPayMentImpl;
import BitStore.ui.LoginUI;
import BitStore.util.Product;
import BitStore.util.PurChase;

public class BitStoreUI {
	private Scanner sc = new Scanner(System.in);
	private PayMent payment;

	public void useBitStore() {
		while (true) {
			switch (menu()) {
			case 1: // 장바구니 담기, Purchase클래스의 insertBasket(List<Product>) : void
				PurChase purchase = new PurChase();
				purchase.insertBasket(); //미완성!!!
				break;
			case 2: // 장바구니 조회, 
				PurChase purchase2 = new PurChase();
				purchase2.selectBasket(); //미완성!!!
				break;
			case 3: // 상품 구입, Payment pay = n
				if(PurChase.basket.size() >=1) {
					usePurchase(); //구입UI로 이동
				}else {
					System.out.println("장바구니에 최소 1개 이상의 상품을 담아주세요.");
				}
				 //내부 상품 구입 switch 이동
				break;
			case 4: // 상품조회 Product클래스의 selectProduct() : Map<Integer,Product>
				Product product2 = new Product();
				product2.selectProduct();
				break;
			case 5: // 포인트조회 Purchase클래스의 selectPoint(User) : int
				PurChase purchase3 = new PurChase();
				purchase3.selectPoint();
				break;
			case 6: // 돌아가기
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

	public void usePurchase() {
		while (true) {
			switch (purchaseMenu()) {
			case 1: // 상품 할인
				PurChase purchase = new PurChase();
				purchase.discountProduct();
				break;
			case 2: // 결제 방식
				usePayment(); //내부 결제 방식switch 이동
				break;
			case 3: // 돌아가기
				useBitStore();
				break;
			case 0:
				quit();
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}
	}
	
	public void usePayment() {
		while (true) {
			switch (paymentMenu()) {
			case 1: // 현금 구매
				payment = new CashPayMentImpl();
				payment.buy();
				break;
			case 2: // 포인트 구매
				payment = new PointPayMentImpl();
				payment.buy();
				break;
			case 3: // 돌아가기
				usePurchase();
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

	private int menu() {
		System.out.println("-----------------");
		System.out.println("1. 장바구니 담기");
		System.out.println("2. 장바구니 조회");
		System.out.println("3. 상품구입");
		System.out.println("4. 상품조회");
		System.out.println("5. 포인트조회");
		System.out.println("6. 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	private int purchaseMenu() {
		System.out.println("-----------------");
		System.out.println("1. 상품할인");
		System.out.println("2. 결제방식");
		System.out.println("3. 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	private int paymentMenu() {
		System.out.println("-----------------");
		System.out.println("1. 현금 구매");
		System.out.println("2. 포인트 구매");
		System.out.println("3. 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

}
