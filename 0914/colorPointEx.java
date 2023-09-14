
public class colorPointEx {

	public static void main(String[] args) {

		point p= new point();
		p.set(1, 2);
		p.showPoint();
		
		colorPoint cp=new colorPoint();
		cp.set(3, 4);
		cp.setColor("red");
		cp.showColorPoint();
	}

}
