package Mar_23;
import java.io.*;

public class Ex14_DataInputStream {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("score.txt");
			dis = new DataInputStream(fis);
			while(true) {
				score = dis.readInt();
				System.out.print(score + " / ");
				sum += score;
			}
		}catch(Exception e) {
			System.out.println("sum = " + sum);
			
		}finally {
			try {
				
			}catch(Exception e) {
				
			}
			
		}
		
		

	}
}
