package Mar_19;

import java.util.Calendar;

//설계도
//사용자 편하게 ...
//많이 사용할까 ... 유지 보수 (함수이름) ... 다형성 ...
public class Edu_Date {
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "년" +
			   (date.get(Calendar.MONTH)+1) + "월" +
				date.get(Calendar.DATE) + "일";
	}
	public static String DateString(Calendar date , String opr ) {
		return date.get(Calendar.YEAR) + opr +
			   (date.get(Calendar.MONTH)+1) + opr +
				date.get(Calendar.DATE);
	}
	
	public static String monthFormat_DateString(Calendar date) {
		if(date.get((Calendar.MONTH)+1) <= 9) {
			return date.get(Calendar.YEAR) + "년" +
					   "0" + (date.get(Calendar.MONTH)+1) + "월" +
						date.get(Calendar.DATE) + "일";
			
		} else {
			
		}
		return null;
	}
}







