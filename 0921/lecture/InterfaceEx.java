import java.util.Scanner;


interface PhoneInterface {
	final int TIMEOUT = 10000;

	void sendCall();

	void receiveCall();

	default void printLogo() {
		System.out.println("「SAMSUNG」");
	}
}
interface tabletInterface {
	final int TIMEOUT = 10000;

	default void printLogo() {
		System.out.println("「APPLE」");
	}
}
interface MobilePhoneInterface extends PhoneInterface {
	void sendSMS();

	void receiveSMS();
}

interface MP3Interface {
	public void play();
	public void stop();
}

interface DVDInterface {
	public void turnOn();
	public void turnOff();
}

class PDA {
	public int calculate(int x, int y) {
		return x + y;
	}
}
class TabletPC extends PDA implements tabletInterface, MP3Interface,DVDInterface {

	@Override
	public void play() {
		System.out.println("음악재생합니다");
		System.out.println("플레이리스트에 음악이 없습니다 음악을 추가해 주세요.");
	}
	@Override
	public void stop() {
		System.out.println("음악중단합니다");
	}


	@Override
	public void turnOn() {
		System.out.println("채널 찾는중...");
		System.out.println("채널이 없습니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("채널이 없습니다.");
		
	}
}


class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface {

	@Override
	public void sendCall() {
		System.out.println("따르릉 따르릉");

	}

	@Override
	public void receiveCall() {
		System.out.println("전화가 왔습니다");
		System.out.println("전화가 끊겼습니다");
	}

	@Override
	public void sendSMS() {
		Scanner in=new Scanner(System.in);
		String sms;
		System.out.println("문자를 보냅니다");
		System.out.println("송신할 내용을 입력하세요");
		sms=in.nextLine();
		System.out.println("송신되었습니다");

	}

	@Override
	public void receiveSMS() {
		System.out.println("문자를 확인합니다");
		System.out.println("수신된 문자가 없습니다");
	}

	@Override
	public void play() {
		System.out.println("음악재생합니다");
		System.out.println("플레이리스트에 음악이 없습니다 음악을 추가해 주세요.");
	}

	@Override
	public void stop() {
		System.out.println("음악중단합니다");
	}

	public void schedule() {

		System.out.println("일정관리합니다");
		System.out.println("확인된 일정이 없습니다. 일정을 추가해 주세요");
	}
	public void off() {
		System.out.println("전원을 끕니다");
		System.exit(0);
	}

}

public class InterfaceEx {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		TabletPC tablet=new TabletPC();
		SmartPhone phone = new SmartPhone();
		System.out.println("사용할 기기를 입력하세요\nsmartPhone\ttablet");
		String device=in.nextLine();
		if(device.equals("smartPhone")) {
			phone.printLogo();
			System.out.println("-메뉴-");
			while(true) {
				System.out.print("1. 전화걸기\t\t");
				System.out.println("2. 전화확인");
				
				System.out.print("3. 문자송신\t\t");
				System.out.println("4. 문자수신");
				
				System.out.print("5. 음악재생\t\t");
				System.out.println("6. 음악종료");

				System.out.print("7. 일정확인\t\t");
				System.out.println("8. 계산기");
				
				System.out.println("9. 전원끄기");

				System.out.print("메뉴 번호를 입력하세요:");
				String input=in.nextLine();
				
				switch (input) {
				case "1":
					System.out.println("전화를 겁니다");
					phone.sendCall();	
					System.out.println("...\n...");
					System.out.println("연결시간이 초과되었습니다");			
					break;
				case "2":
					phone.receiveCall();				
					break;
				case "3":
					phone.sendSMS();
					break;
				case "4":
					phone.receiveSMS();
					break;
				case "5":
					phone.play();
							break;
				case "6":
					phone.stop();			
					break;
				case "7":
					phone.schedule();
								break;
				case "8":
					System.out.println("더할 두 숫자를 입력하세요");
					int x=in.nextInt();
					int y=in.nextInt();
					System.out.printf("%d + %d = %d\n",x,y,phone.calculate(x, y));
					break;
					
				case "9":
					phone.off();				
					break;

				default:
					break;
				}
			}
			
			
		}
		
		if(device.equals("tablet")) {
			tablet.printLogo();
			System.out.print("1. 음악재생\t\t");
			System.out.println("2. 음악종료");
			
			System.out.print("3. DVD재생\t\t");
			System.out.println("4. DVD종료");

			System.out.print("5. 일정확인\t\t");
			System.out.println("6. 계산기");
			
			System.out.println("7. 전원끄기");
			
			
			while(true) {
				System.out.print("메뉴 번호를 입력하세요:");
				String input=in.nextLine();
				
				switch (input) {
				case "1":
					tablet.play();
					break;
				case "2":
					tablet.stop();		
					break;
				case "3":
					tablet.turnOn();
					break;
				case "4":
					tablet.turnOff();
							
					break;
				case "5":
					phone.schedule();
								break;
				case "6":
					System.out.println("더할 두 숫자를 입력하세요");
					int x=in.nextInt();
					int y=in.nextInt();
					System.out.printf("%d + %d = %d\n",x,y,phone.calculate(x, y));
					break;
					
				case "7":
					phone.off();				
					break;

				default:
					break;
				}
			}
			
			
		}
	}

}
