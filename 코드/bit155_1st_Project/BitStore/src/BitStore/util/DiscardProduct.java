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
				// ���ڿ��� ��¥ ��ü�� ��ȯ
				Date exprtDate = sdf.parse(value.getExprtDate());
				// ��¥ ��
				int date = exprtDate.compareTo(new Date());
				if (date < 0 && !value.getExprtDate().equals("0000-00-00")) {
					// ������� ������ ��
					DiscardProductVO dp = new DiscardProductVO();
					dp.setDiscardProductNo(value.getProductNo());
					dp.setDiscardProductName(value.getProductName());
					dp.setDiscardPrice(value.getPrice());
					dp.setDiscardExprtDate(value.getExprtDate());
					// ����ǰ Map�� put
					BitStore.discardProductList.put(key, dp);
					// ����ǰ�� key�� discardProductKeyList�� add
					discardProductKeyList.add(key);
					// ����ǰ ��� IO�� �����ϱ�
					writeDiscardProduct();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// discardProductKeyList�� ���鼭 productList���� �������ֱ�
		Product p = new Product();
		for (int k : discardProductKeyList) {
			ProductVO dp = BitStore.productList.remove(k);
			p.writeProduct();
			System.out.println(
					dp.getProductName() + " ��ǰ�� ��������� " + dp.getExprtDate() + "���� ��ǰ ��Ͽ��� ���ŵǰ�, ��� ��ǰ ��Ͽ� �߰��Ǿ����ϴ�.");
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
			System.out.println("��� ��ǰ ��� ���忡 �����Ͽ����ϴ�.");
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
		System.out.println("[��� ��ǰ ���]");
		Set<Integer> keys = BitStore.discardProductList.keySet();
		System.out.println("��ǰ��ȣ\t\t��ǰ��\t�ܰ�\t�������");
		for (Integer key : keys) {
			DiscardProductVO value = BitStore.discardProductList.get(key);
			System.out.printf("%d\t%s\t%d\t%s\n", value.getDiscardProductNo(), value.getDiscardProductName(),
					value.getDiscardPrice(), value.getDiscardExprtDate());
		}
	}

}
