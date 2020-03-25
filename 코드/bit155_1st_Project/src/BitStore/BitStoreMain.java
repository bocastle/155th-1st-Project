package BitStore;

import BitStore.ui.User.UserUI;
import BitStore.ui.LoginUI;

public class BitStoreMain {
	public static void main(String[] args) {
//		UserUI bitStore = new UserUI();
//		bitStore.service();
		LoginUI loginUI = new LoginUI();
		loginUI.admin();
		
	}
}
