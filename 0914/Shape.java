
public class Shape {
	public void draw() {
		System.out.println("draws Shape");
	}
}

class Line extends Shape{

	public void draw() {
		System.out.println("draw Line");
	}
}

class Rect extends Shape{

	public void draw() {
		System.out.println("draw Rect");
	}
}

class Triangle extends Shape{

	public void draw() {
		System.out.println("draw Triangle");
	}
}
