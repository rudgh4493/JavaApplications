import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ChatServer extends JFrame implements ActionListener {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	private Receiver receiver;
	private JTextField sender;

	public ChatServer() {
		setTitle("서버 채팅 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		c.setLayout(new BorderLayout());
		receiver = new Receiver();
		receiver.setEditable(false);

		sender = new JTextField();
		sender.addActionListener(this);

		c.add(new JScrollPane(receiver), BorderLayout.CENTER);
		c.add(sender, BorderLayout.SOUTH);

		setSize(400, 200);
		setVisible(true);

		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}

		Thread th = new Thread(receiver);
		th.start();
	}

	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999);
		socket = listener.accept();
		receiver.append("클라이언트로부터 연결 완료");

		int position = receiver.getText().length();
		receiver.setCaretPosition(position);

		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}

	private class Receiver extends JTextArea implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub

			String msg = null;
			while (true) {
				try {
					msg = in.readLine();
				} catch (IOException e) {
					handleError(e.getMessage());
				}
				this.append("\n 0 : " + msg); // JTextArea
				int position = this.getText().length();
				this.setCaretPosition(position);
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == sender) {
			String msg = sender.getText();
			try {
				out.write(msg + "\n");
				out.flush();

				receiver.append("\n서버" + msg);
				int position = receiver.getText().length();

				receiver.setCaretPosition(position);
				sender.setText(null);
			} catch (IOException el) {
				handleError(el.getMessage());
			}
		}

	}

	public static void main(String[] args) {
		new ChatServer();
	}

}
