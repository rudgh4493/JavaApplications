import java.io.*;

public class FileEx{
	
	public static void binaryCopy(String sname, String dname) {
		File src = new File(sname);
		File dest = new File(dname);
		int c;
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			byte[] buf = new byte[1024*10];			
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0 ,n);
				if(n<buf.length) {
					break;
				}					
			}
			
			/*
			while((c=fi.read())!=-1) {
				fo.write((byte)c);
			}*/
					
			fi.close();
			fo.close();
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
}
	}

	public static void listDirectory(File dir) {
		System.out.println("[["+dir.getPath()+"의 서브 리스트입니다.]]");
		File[] subFiles = dir.listFiles();
		for(int i=0;i<subFiles.length;i++) {
			File f =subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일 크기 : "+f.length());
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t,t,t,t);
		}
	}
	public static void main(String[] args) {
		
		listDirectory(new File("c:\\Temp"));
		//binaryCopy("C:\\Users\\629-10\\Desktop\\spot 1.jpg", "c:\\Temp\\s.png");
		binaryCopy("C:\\Users\\629-10\\Desktop\\123.jpg", "c:\\Temp\\land.jpg");
		listDirectory(new File("c:\\Temp"));

		/*
		File f1 = new File("c:\\windows\\system.ini");

		System.out.println("getPath(): \t"+f1.getPath());
		System.out.println("getParnet(): \t"+f1.getParent());
		System.out.println("getName(): \t"+f1.getName());
		
		String res = "";
		if(f1.isFile()) {
			res = "파일";
		}else if(f1.isDirectory()){
			res = "디렉토리";
		}
		System.out.println(f1.getPath()+"는 "+res+"입니다");
		
		File f2=new File("c:\\Temp\\java_sample");
		if(!f2.exists()) {
			f2.mkdir();
		}
		listDirectory(new File("c:\\Temp"));
		f2.renameTo(new File("c:\\Temp\\javasample"));

		listDirectory(new File("c:\\Temp"));
	*/
	}
}
