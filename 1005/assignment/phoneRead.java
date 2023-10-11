import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class phoneRead {

	public static void FileRead(String fname) {
		InputStreamReader in = null;
		FileInputStream fin = null;

		try {
			fin = new FileInputStream(fname);
			in = new InputStreamReader(fin, "UTF-8");

			int c;
			System.out.println(fname + "를 출력한다");
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileRead("c:\\Temp\\phone.txt");
	}
}
