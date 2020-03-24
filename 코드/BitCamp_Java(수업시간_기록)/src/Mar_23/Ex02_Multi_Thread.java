package Mar_23;

class Thread_1 extends Thread {
	@Override
	public void run() { // run() 함수 : main과 동일한 역할 //새로운 stack에 처음 올라가는 함수
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread1 : " + i + this.getName());
		}
		System.out.println("Thread_1 run() END");
	}
}

class Thread_2 implements Runnable { //Runnabel는 구현객체를 가지지 않음
													//Runnable는 스레드의 조건을 가진거지 스레드 자체는 아님
													//스레드가 사용할 함수만 가지고 있음
													//굳이 이걸 사용하는 이유는?-> 만약 extends를 Thread가아닌 다른클래스를 상속하게 해주기 위해서..
	

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread2 : " + i);
		}
		System.out.println("Thread_2 run() END");
	}

}

public class Ex02_Multi_Thread {
	public static void main(String[] args) { //main도 하나의 Thread
		//1번
		Thread_1 th = new Thread_1();
		th.start(); //새로운 stack를 생성 - > stack에 run()함수를 올림
		
		//2번
		Thread_2 th2 = new Thread_2(); //Thread가 아님, 인터페이스만 구현한 클래스
		Thread thread = new Thread(th2);
		thread.start();
	}
}
