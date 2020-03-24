/*
 * ���� ��Ʈ��
 * ���Ͼƿ�ǲ��Ʈ���� ������
 * DataOutputStream�� ���� write�� �� -> ������ ���� ����
 * dos�Ѱ��� ������ dis�θ� ���� �� �ִ�.
 * 
 */

package Mar_23;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex13_DataOutputStream {
	public static void main(String[] args) {
		int[] score = {100,65,55,94,23};
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos =  new FileOutputStream("score.txt");
			dos = new DataOutputStream(fos);
			for(int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]); //���Ŀ� �´� Ÿ�� �����Ͽ� write ����
											   //������wrie >> read DataInputStream
				//dos.writeUTF(str); //web���� �ַ� ����ϴ� �ѱ�ó�� ���ڵ�..(����,�ѱ�,���鹮�� �� ���� ���)
				//�̰� ���� �����
				//���ϸ���or����write�� ����ص� ��
				//io�� ���� �뵵�� Ŭ�������� ����
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
