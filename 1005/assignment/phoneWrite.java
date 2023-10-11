import java.io.*;
import java.util.Scanner;

public class phoneWrite {

   public static void FileWriter(String fname) {
	   Scanner scanner = new Scanner(System.in);
	   FileWriter fout = null;
	   System.out.println();
	   System.out.println("전화번호 입력 프로그램입니다.");
	   
	   try {
		   fout =new FileWriter(fname);
		   while(true) {
			   System.out.println(fname);
			   System.out.print("이름 전화번호 >> ");
			   String line = scanner.nextLine();
			   if(line.equals("그만")) {
				   break;
			   }
			   fout.write(line, 0, line.length());
			   fout.write("\r\n", 0, 2);
		   }
		   fout.close();
	   }catch(IOException e){
		   System.out.println("입출력 오류");
	   }
	   scanner.close();
   }
   
   public static void main(String[] args) {

       FileWriter("c:\\Temp\\phone.txt");
   }

}