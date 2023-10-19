import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {
	public Calculator() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);

		setSize(370, 300);
		setVisible(true);
	}

	class NorthPanel extends JPanel {
		public NorthPanel() {
			setLayout(new FlowLayout(FlowLayout.LEFT));
			setBackground(Color.LIGHT_GRAY);

			JLabel j = new JLabel(" 수식입력");
			JTextField f = new JTextField("\t\t\t");

			add(j);
			add(f);
		}
	}

	class CenterPanel extends JPanel {
		public CenterPanel() {
			setLayout(new GridLayout(4, 4, 5, 5));

			for(int i=0; i<=9; i++) {
				JButton b =new JButton(Integer.toString(i));
				add(b);
			}

			JButton bCE = new JButton("CE");		JButton bCAL = new JButton("계산");
			JButton bA = new JButton("+");		JButton bB = new JButton("-");
			JButton bC = new JButton("x");		JButton bD = new JButton("/");

			bA.setBackground(Color.CYAN);
			bB.setBackground(Color.CYAN);
			bC.setBackground(Color.CYAN);
			bD.setBackground(Color.CYAN);

			add(bCE);		add(bCAL);		add(bA);		
			add(bB);		add(bC);		add(bD);
		}

	}

	class SouthPanel extends JPanel {
		public SouthPanel() {
			setLayout(new FlowLayout(FlowLayout.LEFT));
			setBackground(Color.YELLOW);

			JLabel j = new JLabel(" 계산 결과");
			JTextField f = new JTextField("\t\t\t");

			add(j);
			add(f);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}

}