import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ThreadTimerEx extends JFrame {
	public ThreadTimerEx() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		TimerThread th = new TimerThread(timerLabel);
		
		JButton btn = new JButton("Kill Timer");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	th.interrupt();
				th.finish();
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false);
				
			}
		});
		c.add(btn);
		setSize(300, 170);
		setVisible(true);
		th.start();
	}

	public static void main(String[] args) {
		new ThreadTimerEx();
	}
}