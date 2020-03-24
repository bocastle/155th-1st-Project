package Mar_19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex02_Point_File_Read_Write {
	public static void main(String[] args) {
		try {
//			String path = "C:\\Users\\bitcamp\\workspace\\BitCamp_Java\\a.txt";
			FileInputStream fs = new FileInputStream("a.txt");
			int data = 0;
			while((data = fs.read()) != -1) {
				System.out.print((char)data);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
