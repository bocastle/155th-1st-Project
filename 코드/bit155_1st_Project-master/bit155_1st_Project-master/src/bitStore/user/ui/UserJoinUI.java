package bitStore.user.ui;

import bitStore.user.dao.UserJoinLoginDAO;

public class UserJoinUI extends UserBaseUI {
	private UserJoinLoginDAO dao;
	
	public UserJoinUI(UserJoinLoginDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void service() {
		// TODO Auto-generated method stub
		
	}
}
