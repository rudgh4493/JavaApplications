import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class JComponentEx extends JFrame {
	ImageIcon cherryIcon =  new ImageIcon("images/cherry.jpg");
	ImageIcon selectedCherryIcon =  new ImageIcon("images/selectedCherry.jpg");
	JCheckBox apple = new JCheckBox("사과");
	JCheckBox pear= new JCheckBox("배");
	JCheckBox cherry= new JCheckBox("체리", cherryIcon);
	private JLabel sumLabel;
	public JComponentEx() {
		super("JComponent의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton("	Disabled Button	");
		JButton b3 = new JButton("getX(), getY()");
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		b2.setEnabled(false);
		b3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX() + "," + b.getY());	
			}
		});
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
	//	JLabel textLabel = new JLabel("사랑합니다");
		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel("사랑합니다", beauty, SwingConstants.CENTER);
		c.add(imageLabel);
//
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		
		JButton btn = new JButton("call~~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		c.add(btn);
		//
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);
		//
		
		MyItemListener listener = new MyItemListener();
		apple.addItemListener(listener);
		pear.addItemListener(listener);
		cherry.addItemListener(listener);
		
		JLabel textLabel = new JLabel("사과 100원, 배 500원, 체리 20000원");
		sumLabel = new JLabel("현재 0원 입니다.");
		
		c.add(textLabel);
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		c.add(sumLabel);
		//
		
		setSize(500, 900);
		setVisible(true);
	}
	class MyItemListener implements ItemListener{
		private int sum = 0;
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(e.getItem() == apple) {
					sum += 100;
				}else if(e.getItem() == pear) {
					sum += 500;
				}else {
					sum += 20000;
				}
			}else {
				if(e.getItem() == apple) {
					sum -= 100;
				}else if(e.getItem() == pear) {
					sum -= 500;
				}else {
					sum -= 20000;
				}
			}
			sumLabel.setText("현재 " + sum + "원 입니다");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JComponentEx();
	}

}
