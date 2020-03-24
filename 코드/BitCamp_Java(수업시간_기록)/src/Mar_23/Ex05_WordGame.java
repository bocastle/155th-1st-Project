package Mar_23;

import javax.swing.JOptionPane;

class Timer extends Thread {
	@Override
	public void run() {

		for (int i = 10; i > 0; i--) {
			if (Ex05_WordGame.flag == true) {
				try {
					System.out.println("남은 시간 : " + i);
					sleep(1000);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}

class WordInput extends Thread {
	@Override
	public void run() {
		String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("입력값 : " + inputdata);
		Ex05_WordGame.flag = false;
	}
}

public class Ex05_WordGame {
	static boolean flag = true;

	public static void main(String[] args) {
		WordInput wi = new WordInput();
		wi.start();

		Timer timer = new Timer();
		timer.start();

	}
}
