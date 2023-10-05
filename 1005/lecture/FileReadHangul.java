import java.io.*;
import java.util.Scanner;

public class FileReadHangul {

   public static void FileRead(String fname) {
       InputStreamReader in = null;
       FileInputStream fin = null;
       
       try {
           fin = new FileInputStream(fname);
           in = new InputStreamReader(fin, "UTF-8");
           
           int c;
           System.out.println("인코딩 문자 집합은 "+in.getEncoding());
           while((c = in.read()) != -1) {
               System.out.print((char)c);
           }
           in.close();
           fin.close();            
       }catch(IOException e) {
           System.out.println("입출력 오류");
       }
   }
   
   public static void FileWriter(String fname) {
	   Scanner scanner = new Scanner(System.in);
	   FileWriter fout = null;
	   System.out.println();
	   System.out.println("내용을 작성해주세요. 그만하려면 엔터 두번");
	   try {
		   fout =new FileWriter(fname);
		   while(true) {
			   String line = scanner.nextLine();
			   if(line.length()==0) {
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
       // TODO Auto-generated method stub
       FileRead("c:\\Temp\\hangul.txt");
       FileWriter("c:\\Temp\\test.txt");
   }

}