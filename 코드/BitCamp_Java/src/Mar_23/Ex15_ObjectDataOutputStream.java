package Mar_23;

import java.io.*;

public class Ex15_ObjectDataOutputStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null;
		try {
			//삼총사
			fos = new FileOutputStream(filename, true);
			bos = new BufferedOutputStream(fos); //버퍼를 이용한 직렬화가 성능상 좋음
			//직렬화 시작
			out = new ObjectOutputStream(bos);
			UserInfo u1 = new UserInfo("홍길동","man",500); //완제품
			UserInfo u2 = new UserInfo("유관순","girl",600); //완제품
			
			//직렬화 작업
			out.writeObject(u1); //분해한 뒤 줄을 세워서 파일에 write
			out.writeObject(u2);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}finally {
			try {
				out.close();
				bos.close();
				fos.close();
				System.out.println("파일 생성 -> buffer -> 직렬화 -> 파일write");
			}catch(Exception e) {
				
			}
			
		}
		
		

	}
}
