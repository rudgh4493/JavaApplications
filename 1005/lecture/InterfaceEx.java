import java.util.Iterator;
import java.util.Vector;

public class InterfaceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SmartPhone myphone = new SmartPhone();
		myphone.savePhonebook("내번호", "01012345678");
		myphone.savePhonebook("엄마번호", "01011112222");
		myphone.savePhonebook("아빠번호", "01033334444");
		myphone.savePhonebook("동생번호", "01055556666");
		myphone.savePhonebook("누나번호", "01077778888");
		myphone.savePhonebook("형번호", "01099990000");

		System.out.println("아빠번호 찾기: "+myphone.findPhonenum("아빠번호"));
		System.out.println("형번호 찾기: "+myphone.findPhonenum("형번호"));
		
		/*
		Vector<SmartPhone> spv= new Vector<SmartPhone>();
		spv.add(new SmartPhone("내 폰"));
		spv.add(new SmartPhone("니 폰"));
		spv.add(new SmartPhone("아이폰"));
		spv.add(new SmartPhone("갤럭시폰"));
		
		for(int i=0; i<spv.size();i++) {
			SmartPhone s = spv.get(i);
			s.printLogo();
			System.out.println("Phone Name : " + s.getPhonename());
		}
		System.out.println("----------");
		
		Iterator<SmartPhone> it = spv.iterator();
		while(it.hasNext()) {
			SmartPhone s = it.next();
			s.printLogo();
			System.out.println("Phone Name : " + s.getPhonename());
		}
		*/
		/*
		SmartPhone phone = new SmartPhone();
		phone.alarm();
		phone.printLogo();
		phone.calculate(1, 2);
		phone.play();
		phone.receiveSMS();
		phone.stop();
		phone.sendSMS();
		phone.sendCall();
		*/
	}

}
