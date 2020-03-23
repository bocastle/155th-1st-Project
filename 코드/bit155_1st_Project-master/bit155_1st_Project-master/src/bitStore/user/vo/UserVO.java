package bitStore.user.vo;

public class UserVO {
	String userID; //회원 ID
	String userPwd; //회원 비밀번호
	String userName; //회원명
	String userPhone; //회원 핸드폰번호
	int userPoint; //회원이 가지고있는 point
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
