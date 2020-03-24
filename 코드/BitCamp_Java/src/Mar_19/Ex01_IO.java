package Mar_19;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex01_IO {
	public static void main(String[] args) {
		byte[] inSrc = {10,1,3,3,6}; //자원(리소스)
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
		//toByteArray >> 자기가 가지고 있는 값을 배열로 만들어서 그 주소값을 전달
		
		
	}
}


