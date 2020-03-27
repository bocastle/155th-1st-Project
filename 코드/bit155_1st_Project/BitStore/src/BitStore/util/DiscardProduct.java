package BitStore.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import BitStore.domain.DiscardProductVO;
import BitStore.domain.ProductVO;

public class DiscardProduct {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public void insertDiscardProduct() {
		Iterator<Integer> keys = BitStore.productList.keySet().iterator();
		List<Integer> discardProductKeyList = new ArrayList<>();
		while (keys.hasNext()) {
			int key = keys.next();
			ProductVO value = BitStore.productList.get(key);
			try {
				// 문자열을 날짜 객체로 변환
				Date exprtDate = sdf.parse(value.getExprtDate());
				// 날짜 비교
				int date = exprtDate.compareTo(new Date());
				if (date < 0 && !value.getExprtDate().equals("0000-00-00")) {
					// 유통기한 지났을 때
					DiscardProductVO dp = new DiscardProductVO();
					dp.setDiscardProductNo(value.getProductNo());
					dp.setDiscardProductName(value.getProductName());
					dp.setDiscardPrice(value.getPrice());
					dp.setDiscardExprtDate(value.getExprtDate());
					// 폐기상품 Map에 put
					BitStore.discardProductList.put(key, dp);
					// 폐기상품의 key를 discardProductKeyList에 add
					discardProductKeyList.add(key);
					// 폐기상품 목록 IO로 저장하기
					writeDiscardProduct();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// discardProductKeyList를 돌면서 productList에서 삭제해주기
		Product p = new Product();
		for (int k : discardProductKeyList) {
			ProductVO dp = BitStore.productList.remove(k);
			p.writeProduct();
			System.out.println(
					dp.getProductName() + " 상품의 유통기한이 " + dp.getExprtDate() + "으로 상품 목록에서 제거되고, 폐기 상품 목록에 추가되었습니다.");
		}
	}

	public void writeDiscardProduct() {
		File file = new File("discardProductList.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(BitStore.discardProductList);
		} catch (Exception e) {
			System.out.println("폐기 상품 목록 저장에 실패하였습니다.");
			e.getStackTrace();
		} finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selectDiscardProduct() {
		System.out.println("[폐기 상품 목록]");
		Set<Integer> keys = BitStore.discardProductList.keySet();
		System.out.println("상품번호\t\t상품명\t단가\t유통기한");
		for (Integer key : keys) {
			DiscardProductVO value = BitStore.discardProductList.get(key);
			System.out.printf("%d\t%s\t%d\t%s\n", value.getDiscardProductNo(), value.getDiscardProductName(),
					value.getDiscardPrice(), value.getDiscardExprtDate());
		}
	}

}
