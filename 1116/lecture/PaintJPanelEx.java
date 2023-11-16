import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintJPanelEx extends JFrame {
	private MyPanel panel = new MyPanel();

	public PaintJPanelEx() {
		setTitle("paintComponent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(400,400);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 150, 150);
			g.setColor(Color.MAGENTA);
			g.drawOval(100, 100, 100, 100);
			g.setColor(new Color(128,128,50));
			g.setFont(new Font("궁서체",Font.BOLD,50));
			g.drawString("점메추", 20, 300);
			g.fillArc(20, 100, 80, 80, 90, 270);
			int[]x = {80,40,80,120};
			int[]y = {40,120,200,120};
			g.drawPolygon(x,y,4);
		};
		
	}

	public static void main(String[] args) {
		new PaintJPanelEx();
	}

}
