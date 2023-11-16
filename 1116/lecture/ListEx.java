import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListEx extends JFrame {
	private String [] fruits = {"apple","banana","kiwi",
			"mango","pear","peach","berry","strawberry","blackberry"};
	private ImageIcon [] images = {
		new ImageIcon("images/icon1.png"),
		new ImageIcon("images/icon2.png"),
		new ImageIcon("images/icon3.png"),
		new ImageIcon("images/icon4.png")	
	};
	
	public ListEx() {
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JList<String> strList = new JList<String>(fruits);
		c.add(new JScrollPane(strList));
		
		JList<ImageIcon> imgList = new JList<ImageIcon>(images);
		c.add(imgList);
		
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListEx();
	}

}
