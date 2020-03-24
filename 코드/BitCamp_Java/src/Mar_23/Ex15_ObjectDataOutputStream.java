package Mar_23;

import java.io.*;

public class Ex15_ObjectDataOutputStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null;
		try {
			//���ѻ�
			fos = new FileOutputStream(filename, true);
			bos = new BufferedOutputStream(fos); //���۸� �̿��� ����ȭ�� ���ɻ� ����
			//����ȭ ����
			out = new ObjectOutputStream(bos);
			UserInfo u1 = new UserInfo("ȫ�浿","man",500); //����ǰ
			UserInfo u2 = new UserInfo("������","girl",600); //����ǰ
			
			//����ȭ �۾�
			out.writeObject(u1); //������ �� ���� ������ ���Ͽ� write
			out.writeObject(u2);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}finally {
			try {
				out.close();
				bos.close();
				fos.close();
				System.out.println("���� ���� -> buffer -> ����ȭ -> ����write");
			}catch(Exception e) {
				
			}
			
		}
		
		

	}
}
