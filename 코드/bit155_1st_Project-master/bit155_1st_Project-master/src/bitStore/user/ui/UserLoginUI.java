package bitStore.user.ui;

import bitStore.user.dao.UserJoinLoginDAO;

public class UserLoginUI extends UserBaseUI {
private UserJoinLoginDAO dao;
	
	public UserLoginUI(UserJoinLoginDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void service() {
		// TODO Auto-generated method stub
		
	}
}
