import java.awt.*;
import javax.swing.*;

class TimerThread extends Thread {
	private JLabel timerLabel;
	private boolean flag=false; // 스레드의 종료 명령을 표시하는 플래그. true : 종료 지시
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	void finish() { // 스레드 종료 명령을 flag에 표시
		flag = true;
		}
	@Override
	public void run() {
		int n = 0;
		while (true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}