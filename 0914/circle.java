
public class circle {
	int radius;
	String name;

	public circle() {
	}

	public circle(int radius, String name) {
		this.radius = radius;
		this.name = name;
	}

	public circle(int radius) {
		this.radius = radius;
	}

	public double getArea() {
		return 3.14 * radius * radius;
	}
}
