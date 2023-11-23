import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx1 extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawImageEx1() {
		setTitle("이미지 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300,420);
		setVisible(true);
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawImageEx1();
	}
	
	class MyPanel extends JPanel{
//		private ImageIcon icon = new ImageIcon("images/img.jpg");
//		private Image img = icon.getImage();
		private Vector<Point> vStart = new Vector<Point>();
		private Vector<Point> vEnd = new Vector<Point>();
		
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point startP = e.getPoint();
					vStart.add(startP);
				}
				public void mouseReleased(MouseEvent e) {
					Point endP = e.getPoint();
					vEnd.add(endP);
					
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			
			for(int i=0;i<vStart.size();i++) {
				Point s = vStart.elementAt(i);
				Point e = vEnd.elementAt(i);
				g.drawLine((int)s.getX(),(int)s.getY(),(int)e.getX(),(int)e.getY());
			}
			
//			g.drawImage(img, 20, 20, this);
//			g.drawImage(img, 10, 10, 100, 100, this);
//			g.drawImage(img, 20, 20, 250, 100, 150, 50, 200, 200,this);
			
//			g.setClip(100,20,150,150);
//			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
//			g.setColor(Color.YELLOW);
//			g.setFont(new Font("Arial", Font.ITALIC, 40));
//			g.drawString("Go Gator", 10, 150);
		}
		
	}
}
