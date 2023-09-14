
public class testShape {

	public static void main(String[] args) {

		Shape shape=new Shape();
		shape.draw();
		
		Line line=new Line();
		
		Triangle t= new Triangle();
		t.draw();
/*
		Circle pizza = new Circle();
		pizza.radius = 4;
		pizza.name="고르곤졸라";
		double area= pizza.getArea();
		System.out.println(pizza.name+"의 크기: "+area);
		
		Circle apple= new Circle(5, "사과");
		System.out.println(apple.name+"의 크기: "+apple.getArea());
		*/
		/*
		circle[] c;
		c= new circle[5];
		
		for(int i=0;i<c.length;i++) {
			c[i]=new circle(i);
			System.out.println((int)(c[i].getArea())+" ");
		}
		*/
		
	}
}
