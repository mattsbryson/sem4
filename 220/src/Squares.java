
public class Squares 
{
	public static void main(String args)
	{
		double [] x = {1.2, 3.4, 6.7};
		
		printArray(x);
		
		x[1] = 94;
		
		printArray(x);
		
	}
	
	public static void printArray(double []x)
	{
		for(int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
	}

}
