package Mar_23;

import java.io.Serializable;

/*
 * ����ȭ : ��ü�� �����ؼ� ���� ���� ������ ����
 * ������ȭ : ���ص� ��ü�� �ٽ� �����ϴ� ����
 * 
 * ����ȭ ����� ���赵���� �ٸ�(Ŭ���� ���� implements Serializable�̰� �پ�����)
 */


public class UserInfo implements Serializable{
	private String name;
	private String pwd;
	private int age;
	
	public UserInfo() {}
	public UserInfo(String name, String pwd, int age) {
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
	}
	
}
