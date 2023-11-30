
public class StudentThread extends Thread {
	private SharedBoard board; // 집계판의 주소

	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			board.add();
	}
}
