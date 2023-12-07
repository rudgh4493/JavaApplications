import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClient extends JFrame implements ActionListener{
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private Socket socket = null;
	private Receiver receiver;
	private JTextField sender;
	
	public ChatClient() {
		setTitle("클라이언트 채팅 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		receiver = new Receiver();
		receiver.setEditable(false);
		
		sender = new JTextField();
		sender.addActionListener(this);
		
		c.add(new JScrollPane(receiver), BorderLayout.CENTER);
		c.add(sender, BorderLayout.SOUTH);
		
		setSize(400,200);
		setVisible(true);
		
		try {
			setupConnection();
		}catch(IOException e) {
			handleError(e.getMessage());
		}
		
		Thread th = new Thread(receiver);
		th.start();
	}
	private void setupConnection() throws IOException{
		socket = new Socket("localhost", 9999);
		receiver.append("서버에 연결 완료");
		
		int position = receiver.getText().length();
		receiver.setCaretPosition(position);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	private class Receiver extends JTextArea implements Runnable{
		@Override
		public void run() {
			String msg = null;
			while(true) {
				try {
					msg = in.readLine();	//상대로부터 한 문장 읽기
				}catch(IOException e) {
					handleError(e.getMessage());
				}
				//JTextArea에 출력하기
				this.append("\n 서버 : "+msg);
				int position = this.getText().length();
				this.setCaretPosition(position);
			}
		}
	}
	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sender) {
			String msg = sender.getText();
			try {
				//문자열 전송 
				out.write(msg+"\n");
				out.flush();
				//출력
				receiver.append("\n클라이언트 : "+msg);
				int position = receiver.getText().length();
				receiver.setCaretPosition(position);
				sender.setText(null);
			}catch(IOException e1) {
				handleError(e1.getMessage());
			}
		}
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient();
	}
}