import java.util.HashMap;

public class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface{
	//MobilePhoneInterface의 추상 메소드 구현
	private String phonename = "";
	//전화번호부 구현을 위한 해쉬맵
	private HashMap<String, String> phonebook = new HashMap<String, String>();
	
	public SmartPhone() {}//생성자
	public SmartPhone(String name) {
		phonename = name;
	}
	
	public void savePhonebook(String key, String value) {//전화번호부 저장
		phonebook.put(key, value);
	}
	public String findPhonenum(String key) {//번호찾기
		return phonebook.get(key);
	}
	
	public String getPhonename() {//이름가져오는 메서드
		return phonename;
	}
	
	@Override
	public void sendCall() {
		System.out.println("전화를 겁니다. 따르릉!");
	}
	@Override
	public void receiveCall() {
		System.out.println("전화를 받습니다. 여보세요!");
	}
	@Override
	public void sendSMS() {
		System.out.println("문자를 보냅니다.");
	}
	@Override
	public void receiveSMS() {
		System.out.println("문자를 받습니다.");
	}
	//MP3Interface의 추상메소드구현
	@Override
	public void play() {
		System.out.println("음악을 재생합니다.");
	}
	@Override
	public void stop() {
		System.out.println("음악을 멈춥니다.");
	}
	//추가로 작성할 메소드
	public void alarm() {
		System.out.println("일어나서 밥먹자!");
	}
}
