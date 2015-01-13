
public class rCaller {

	public static void main(String[] args) 
	{
		Rectangle one = new Rectangle();
		Rectangle two = new Rectangle(5,5);
		
		System.out.println("Area: " + one.getArea());
		System.out.println("Perimeter: " + one.getPerimeter());
		System.out.println("Area: " + two.getArea());
		System.out.println("Perimeter: " + two.getPerimeter());
	}

}
