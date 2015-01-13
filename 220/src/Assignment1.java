/*
 * Matt Bryson
 * 1-29-13
 * CSC 220
 */


import java.util.Random;

public class Assignment1 {

	public static void main(String[] args) 
	{
		//create random number generator 
		Random gen = new Random();
		//set array to the returned double array from the Part1 method
		double[] randArray = Part1(5,gen);
		//the array is passed to the print method, where it is printed 
		Part2(randArray);

	}
	
	public static double[] Part1(int N, Random R)
	{
		//create array
		double [] rand = new double [N];
		//loop for the number of times N, generating random numbers
		for(int i = 0; i < N; i++)
		{
			rand[i] = R.nextDouble();
		}
		//return array
		return rand;
	}
	
	//print array
	public static void Part2(double[] rand)
	{
		for(int i = 0; i < rand.length; i++)
		{
			//print with comma until last value
			if(i < rand.length - 1)
			{
				System.out.print(rand[i] + ",");
			}
			else
			{
				System.out.print(rand[i]);
			}
		}
	}
	
}

/*
 * Sample output
 * 0.5808682302064422,0.6544257352275229,0.9883820897012278,0.19365115845494008,0.32770227506746763
 * 
*/