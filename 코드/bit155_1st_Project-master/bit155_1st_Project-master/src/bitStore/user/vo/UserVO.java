package bitStore.user.vo;

public class UserVO {
	String userID; //ȸ�� ID
	String userPwd; //ȸ�� ��й�ȣ
	String userName; //ȸ����
	String userPhone; //ȸ�� �ڵ�����ȣ
	int userPoint; //ȸ���� �������ִ� point
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	@Override
	public String toString() {
		return "BoardVO [userID=" + userID + ", userPwd=" + userPwd + ", userName=" + userName + ", userPhone="
				+ userPhone + ", userPoint=" + userPoint + "]";
	}
}
