
public interface PhoneInterface {
	public static final int TIMEOUT = 10000;
	void sendCall();
	void receiveCall();
	public default void printLogo() {
		System.out.println("** Phone **");
	}
}
