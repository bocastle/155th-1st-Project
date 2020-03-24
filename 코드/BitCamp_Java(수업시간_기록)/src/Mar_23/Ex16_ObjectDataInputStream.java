//����ȭ�� ��ü�� 2��
//��ü�� read�ؼ� �����·� ����

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
			bis = new BufferedInputStream(fis); //���۸� �̿��� ����ȭ�� ���ɻ� ����
			in = new ObjectInputStream(bis);
				
//			UserInfo r1 = (UserInfo)in.readObject();
//			UserInfo r2 = (UserInfo)in.readObject();
			//���� ��ü�ϳ��� �ϱ� ������ �������� �˾Ƶ� ���
//			System.out.println(r1.toString());
//			System.out.println(r2.toString());
			//��ü�� ������ ����� �𸦋�
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
