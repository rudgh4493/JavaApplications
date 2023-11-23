import javax.swing.*;
import java.awt.*;

public class ToolBarEx extends JFrame {
	private Container contentPane;

	public ToolBarEx() {
		setTitle("툴바 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(400, 200);
		setVisible(true);
	}

	private void createToolBar() {
		JToolBar toolBar = new JToolBar("Kitae Menu");
		
		toolBar.setBackground(Color.LIGHT_GRAY);
		JButton b1 = new JButton("New");
		b1.setToolTipText("새 파일을 만듭니다.");
		toolBar.add(b1);
		JButton b2 = new JButton(new ImageIcon("images/open.jpg"));
		b2.setToolTipText("파일을 엽니다.");
		toolBar.add(b2);
		
		
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton(new ImageIcon("images/open.jpg")));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("images/save.jpg")));
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField("text field"));
		JComboBox combo = new JComboBox();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolBar.add(combo);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);
		m.setDismissDelay(10000);
	}

	public static void main(String[] args) {
		new ToolBarEx();
	}
}