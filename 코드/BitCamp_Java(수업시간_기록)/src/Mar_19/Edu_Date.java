package Mar_19;

import java.util.Calendar;

//���赵
//����� ���ϰ� ...
//���� ����ұ� ... ���� ���� (�Լ��̸�) ... ������ ...
public class Edu_Date {
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "��" +
			   (date.get(Calendar.MONTH)+1) + "��" +
				date.get(Calendar.DATE) + "��";
	}
	public static String DateString(Calendar date , String opr ) {
		return date.get(Calendar.YEAR) + opr +
			   (date.get(Calendar.MONTH)+1) + opr +
				date.get(Calendar.DATE);
	}
	
	public static String monthFormat_DateString(Calendar date) {
		if(date.get((Calendar.MONTH)+1) <= 9) {
			return date.get(Calendar.YEAR) + "��" +
					   "0" + (date.get(Calendar.MONTH)+1) + "��" +
						date.get(Calendar.DATE) + "��";
			
		} else {
			
		}
		return null;
	}
}







