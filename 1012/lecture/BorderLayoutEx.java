import java.awt.*;

import javax.swing.*;

public class BorderLayoutEx extends JFrame{
	public BorderLayoutEx() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(30,20));
		c.add((new JButton("add")), BorderLayout.CENTER);
		c.add((new JButton("sub")), BorderLayout.NORTH);
		c.add((new JButton("mul")), BorderLayout.SOUTH);
		c.add((new JButton("div")), BorderLayout.EAST);
		c.add((new JButton("Calculate")), BorderLayout.WEST);
		
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLayoutEx();
	}

}
