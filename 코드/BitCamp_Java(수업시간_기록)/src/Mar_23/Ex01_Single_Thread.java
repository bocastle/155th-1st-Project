package Mar_23;

public class Ex01_Single_Thread {
	public static void main(String[] args) {
		System.out.println("�� main �ϲ��̾�");
		worker();
		worker2();
		System.out.println("main �ϲ� ����");
	}
	
	static void worker() {
		System.out.println("�� 1�� �ϲ��̾�");
	}
	static void worker2() {
		System.out.println("�� 2�� �ϲ��̾�");
	}
}
