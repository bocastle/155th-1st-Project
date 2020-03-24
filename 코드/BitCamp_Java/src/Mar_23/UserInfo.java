package Mar_23;

import java.io.Serializable;

/*
 * 직렬화 : 객체를 분해해서 줄을 세워 보내는 과정
 * 역직렬화 : 분해된 객체를 다시 조립하는 과정
 * 
 * 직렬화 대상은 설계도부터 다름(클래스 옆에 implements Serializable이게 붙어있음)
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
