import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListChangeEx extends JFrame{
	private JTextField tf= new JTextField(10);
	private Vector<String> v =new Vector<>();
	private JList<String> nameList = new JList<String>(v);
	
	public ListChangeEx(){
		setTitle("List Change");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름 입력 후 엔터를 치세요"));
		c.add(tf);

		v.add("황기태");
		v.add("이재문");
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellWidth(100);
		c.add(new JScrollPane(nameList));
		
		setSize(300,300);
		setVisible(true);
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText());
				t.setText("");
				nameList.setListData(v);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListChangeEx();
	}

}
