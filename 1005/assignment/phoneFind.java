import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class phoneFind {

	public static void main(String[] args) {

		HashMap<String, String> value = new HashMap<String, String>();
		Scanner in = new Scanner(System.in);
		String line = null;
		String name = null;
		String[] parts = null;
		String filePath = "c:\\Temp\\phone.txt";
		int count = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));

			while ((line = reader.readLine()) != null) {
				parts = line.split("\\s+");
				count++;
				if (parts.length == 2) {
					value.put(parts[0], parts[1]);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}

		System.out.println("총 " + count + "개의 전화번호를 읽었습니다.");
		while (true) {
			System.out.print("이름 >> ");
			name = in.nextLine();
			String phone = value.get(name);

			if (name.equals("그만")) {
				break;
			}
			if (phone == null) {
				System.out.println("찾는 이름이 없습니다.");

			} else {
				System.out.println(phone);
			}
		}
	}
}