package Mar_19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex10_Format_Date {
	public static void main(String[] args) throws ParseException {
		Date curdate = new Date(); // 구
		Calendar cal = Calendar.getInstance(); // 신
		System.out.println("Date : " + curdate); // format
		System.out.println("Date : " + cal); // 문자열..
		System.out.println("cal getTime() : " + cal.getTime()); // format

		String StringDate = "202012121212";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		System.out.println(sdf.format(curdate));
		System.out.println(sdf.format(cal.getTime()));

		//문자열(날짜형식맞게) -> 날짜형식으로 변환
		Date stringdate = sdf.parse(StringDate);
		System.out.println(stringdate);
		
		long datelong = stringdate.getTime();
		
	}
}
