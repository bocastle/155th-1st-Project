package Mar_19;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex01_IO {
	public static void main(String[] args) {
		byte[] inSrc = {10,1,3,3,6}; //�ڿ�(���ҽ�)
		byte[] outSrc = null; 
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
//		System.out.println(	Arrays.toString(outSrc) );
		
		int data = 0;
		while( (data = input.read()) != -1) {
			System.out.print(data + " / ");
			output.write(data);
		}
		outSrc = output.toByteArray();
		//toByteArray >> �ڱⰡ ������ �ִ� ���� �迭�� ���� �� �ּҰ��� ����
		
		
	}
}


