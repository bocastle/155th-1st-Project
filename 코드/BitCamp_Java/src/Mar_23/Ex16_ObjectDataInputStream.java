//직렬화된 객체가 2개
//객체를 read해서 원상태로 복원

package Mar_23;

import java.io.*;

public class Ex16_ObjectDataInputStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis); //버퍼를 이용한 직렬화가 성능상 좋음
			in = new ObjectInputStream(bis);
				
//			UserInfo r1 = (UserInfo)in.readObject();
//			UserInfo r2 = (UserInfo)in.readObject();
			//보통 객체하나를 하기 때문에 이정도만 알아도 충분
//			System.out.println(r1.toString());
//			System.out.println(r2.toString());
			//객체의 개수가 몇개인지 모를떄
			Object users = null;
			while((users = in.readObject()) != null) {
				System.out.println(((UserInfo)users).toString());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}finally {
			try {
				in.close();
				bis.close();
				fis.close();
			}catch(Exception e) {
				
			}
			
		}
		
		

	}
}
