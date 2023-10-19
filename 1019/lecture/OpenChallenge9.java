import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpenChallenge9 extends JFrame {
	public OpenChallenge9() {
		setTitle("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);

		setSize(300, 300);
		setVisible(true);
	}

	class NorthPanel extends JPanel {
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			add(new JButton("Open"));
			add(new JButton("Read"));
			add(new JButton("Close"));
		}
	}

	class CenterPanel extends JPanel {
		public CenterPanel() {
			setLayout(null);
			JLabel a = new JLabel("Hello");
			a.setLocation(130, 50);
			a.setSize(200, 20);
			JLabel b = new JLabel("Love");
			b.setLocation(200, 90);
			b.setSize(200, 20);
			JLabel c = new JLabel("Java");
			c.setLocation(20, 150);
			c.setSize(200, 20);

			add(a);
			add(b);
			add(c);
		}

	}

	public static void main(String[] args) {
		new OpenChallenge9();

	}

}
