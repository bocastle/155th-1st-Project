package BitStore.Interface;

import java.util.List;

import BitStore.util.BitStore;
import BitStore.util.Product;
import BitStore.util.PurChase;
import BitStore.util.User;

public class PointPayMentImpl implements PayMent {
	@Override
	public void buy() {
		if (PurChase.dcFlag == false) {
			if (PurChase.basket.size() != 0) {
				for (int i = 0; i < PurChase.basket.size(); i++) {
					PurChase.totalPrice += PurChase.basket.get(i).getPrice();
				}
			}
		}
		// �������ִ� ����Ʈ���� ������ ������ ���� ���
		if (BitStore.currentLoginUser.getUserPoint() < PurChase.totalPrice) {
			System.out.println("������ ����Ʈ " + BitStore.currentLoginUser.getUserPoint());
			System.out.println("��ǰ �� ���� " + PurChase.totalPrice);
			System.out.println("�����Ͻ� ����Ʈ�� �����մϴ�.");
		} else {
			int point = BitStore.currentLoginUser.getUserPoint() - PurChase.totalPrice;
			BitStore.currentLoginUser.setUserPoint(point);
			System.out.println("���� ���� ����Ʈ : " + BitStore.currentLoginUser.getUserPoint());

			System.out.println("�������ּż� �����մϴ�. �ȳ���������.");
		}
		BitStore.writeUserList();
	}
}
