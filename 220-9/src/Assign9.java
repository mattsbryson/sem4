import java.util.Random;


public class Assign9
{

	public static void main(String[] args)
	{
		
		int m = 2000;
		int n = 1000; 
		int dSum = 0; 
		for(int i = 0; i < m; i++)
		{
			BST temp = BST.random(n);
			dSum += temp.getDepth();
		}
		
		
		 
		
		System.out.println(dSum/m);

	}

}
