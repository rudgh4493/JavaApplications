import java.awt.*;
import javax.swing.*;

public class ContentPane extends JFrame{
	public ContentPane() {
		super("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("ADD"));
		contentPane.add(new JButton("CLOSE"));
		contentPane.add(new JButton("QWE"));
		contentPane.add(new JButton("ASD"));
		contentPane.add(new JButton("ZXC"));
		
		setSize(300,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ContentPane();
	}

}
