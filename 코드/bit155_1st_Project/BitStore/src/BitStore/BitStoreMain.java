package BitStore;

import java.util.Iterator;

import BitStore.domain.UserVO;
import BitStore.ui.BoardUI;
import BitStore.ui.LoginUI;
import BitStore.ui.admin.MemberUI;
import BitStore.ui.admin.ProductUI;
import BitStore.ui.user.BitStoreUI;
import BitStore.ui.user.UserUI;
import BitStore.util.BitStore;

public class BitStoreMain {
	public static void main(String[] args) {

		UserUI userUI = new UserUI();
		userUI.service();

	}
}
