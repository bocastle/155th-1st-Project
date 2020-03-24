package Mar_23;

class Thread_1 extends Thread {
	@Override
	public void run() { // run() �Լ� : main�� ������ ���� //���ο� stack�� ó�� �ö󰡴� �Լ�
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread1 : " + i + this.getName());
		}
		System.out.println("Thread_1 run() END");
	}
}

class Thread_2 implements Runnable { //Runnabel�� ������ü�� ������ ����
													//Runnable�� �������� ������ �������� ������ ��ü�� �ƴ�
													//�����尡 ����� �Լ��� ������ ����
													//���� �̰� ����ϴ� ������?-> ���� extends�� Thread���ƴ� �ٸ�Ŭ������ ����ϰ� ���ֱ� ���ؼ�..
	

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread2 : " + i);
		}
		System.out.println("Thread_2 run() END");
	}

}

public class Ex02_Multi_Thread {
	public static void main(String[] args) { //main�� �ϳ��� Thread
		//1��
		Thread_1 th = new Thread_1();
		th.start(); //���ο� stack�� ���� - > stack�� run()�Լ��� �ø�
		
		//2��
		Thread_2 th2 = new Thread_2(); //Thread�� �ƴ�, �������̽��� ������ Ŭ����
		Thread thread = new Thread(th2);
		thread.start();
	}
}
