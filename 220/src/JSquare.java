
public class JSquare {

	public static void main(String[] args) 
	{
		/*
		int i = 0; 
		/*
		while(i < 101)
		{
			System.out.println("i=" + i + " i^2=" + (int)Math.pow(i, 2));
			i++;
		}
		
		
		do
		{
			System.out.println("i=" + i + " i^2=" + (int)Math.pow(i, 2));
			i++;
		}
		while(i < 101);
		*/
		
		/*
		int sum = 0; 
		for(int i = 0; i < 101; i++)
		{
			sum += i;
			System.out.println(sum);
		}
		*/
		/*
		for(int i = 1; i < 11; i++)
		{
			for(int k = 1; k < 11; k++)
			{
				System.out.print(k*i + " ");
			}
			System.out.print("\n");
		}
		*/
		
		//System.out.println(maxInt(10,20));
		
	}
	
	public static int maxInt(int a, int b)
	{
		int max;
		if(a < b)
		{
			max = b;
		}
		else
		{
			max = a;
		}
		
		return max;
	}
	
	public static double fToC(double f)
	{
		double c = (5.0/9.0) * (f-32);
		return c;
	}

}
