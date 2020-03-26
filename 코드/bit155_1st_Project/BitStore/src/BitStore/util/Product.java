package BitStore.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BitStore.domain.ProductVO;
import BitStore.domain.UserVO;

public class Product {
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public void insertProduct() {
		int productNo = Integer.parseInt("880" + (r.nextInt(900000) + 100000));

		ProductVO product = new ProductVO();
		product.setProductNo(productNo);
		System.out.print("추가할 상품의 이름을 입력하세요: ");
		product.setProductName(sc.nextLine());
		System.out.print("추가할 상품의 재고량을 입력하세요: ");
		product.setStock(Integer.parseInt(sc.nextLine()));
		while (true) {
			System.out.print("추가할 상품의 유통기한을 입력하세요: ");
			String dateDate = sc.nextLine();
			Pattern idPattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
			Matcher matcher = idPattern.matcher(dateDate);
			if (!matcher.matches()) {
				System.out.println("YYYY-MM-DD 형식을 사용하세요.");
			} else {
				product.setExprtDate(dateDate);
				break;
			}
		}
		System.out.print("추가할 상품의 가격을 입력하세요: ");
		product.setPrice(Integer.parseInt(sc.nextLine()));

		BitStore.productList.put(productNo, product);
		System.out.println();

		System.out.println(BitStore.productList);

		writeProduct();
	}

	public void writeProduct() {
		File file = new File("productList.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file, true);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(BitStore.productList);
		} catch (Exception e) {
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

	public void selectProduct() {
		System.out.println("[상품목록 조회]");
		Iterator<Integer> mapIter = BitStore.productList.keySet().iterator();
		while (mapIter.hasNext()) {
			int key = mapIter.next();
			ProductVO value = BitStore.productList.get(key);
			System.out.println(value + " / ");
		}
	}

	public void updateProduct() {
		// 업데이트 로직
		writeProduct();
	}

	public void deleteProduct() {
		// 제거 로직
		writeProduct();
	}

}