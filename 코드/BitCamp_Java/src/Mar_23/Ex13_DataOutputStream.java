/*
 * 보조 스트림
 * 파일아웃풋스트림을 도와줌
 * DataOutputStream를 통해 write를 함 -> 데이터 가공 가능
 * dos한것은 무조껀 dis로만 읽을 수 있다.
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
				dos.writeInt(score[i]); //형식에 맞는 타입 지정하여 write 가능
											   //정수값wrie >> read DataInputStream
				//dos.writeUTF(str); //web에서 주로 사용하는 한글처리 인코딩..(영어,한글,공백문자 등 모든것 허용)
				//이걸 많이 사용함
				//파일리더or파일write을 사용해도 됨
				//io는 같은 용도의 클래스들이 많음
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
