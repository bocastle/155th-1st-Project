package Mar_19;

import java.util.Enumeration;
import java.util.Properties;

public class ex_properties {

	public static void main(String[] args) {
		Properties prop = new Properties();

		// prop�� Ű�� ���� ����
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");

		// prop�� ����� ��ҵ��� Enumeration�� �̿��ؼ� ����Ѵ�.
		Enumeration e = prop.propertyNames();

		while (e.hasMoreElements()) {
			String element = (String) e.nextElement();
			System.out.println(element + "=" + prop.getProperty(element));
		}

		System.out.println();
		prop.setProperty("size", "20"); // size�� ���� 20���� ����
		System.out.println("size=" + prop.getProperty("size"));
		System.out.println("capacity=" + prop.getProperty("capacity", "20"));
		System.out.println("loadfactor=" + prop.getProperty("loadfactor", "0.75"));

		System.out.println(prop); // prop�� ����� ��ҵ� ���
		prop.list(System.out); // prop�� ����� ��ҵ��� ȭ��(System.out)�� ���

	}

}
