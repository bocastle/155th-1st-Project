package Mar_19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex10_Format_Date {
	public static void main(String[] args) throws ParseException {
		Date curdate = new Date(); // ��
		Calendar cal = Calendar.getInstance(); // ��
		System.out.println("Date : " + curdate); // format
		System.out.println("Date : " + cal); // ���ڿ�..
		System.out.println("cal getTime() : " + cal.getTime()); // format

		String StringDate = "202012121212";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		System.out.println(sdf.format(curdate));
		System.out.println(sdf.format(cal.getTime()));

		//���ڿ�(��¥���ĸ°�) -> ��¥�������� ��ȯ
		Date stringdate = sdf.parse(StringDate);
		System.out.println(stringdate);
		
		long datelong = stringdate.getTime();
		
	}
}
