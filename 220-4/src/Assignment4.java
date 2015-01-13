import java.util.Random;
import java.util.Scanner;


public class Assignment4 {

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.print("Please enter the size of N you would like: ");
		int N = reader.nextInt();
		double selAVG = 0;
		double inAVG = 0;
		Random gen = new Random();
		
		for(int i = 0; i < 100; i++)
		{
			double [] arr1 = RandomArray(N, gen);
			double [] arr2 = RandomArray(N, gen);
			//double [] arr1 = {0,1,2,3,4,5,6};
			//double [] arr2 = {0,1,2,3,4,5,6};
			selAVG += selSort(arr1);
			inAVG += inSort(arr2);
			if(!(preSorted(arr1) && preSorted(arr2)))
			{
				System.err.println("The array was not sorted. Stopping program.");
				System.exit(0);
			}
			//PrintDoubleArray(arr1);
		}
		
		selAVG /= 100;
		inAVG /= 100;
		
		System.out.println("Insertsion sort avg: " + inAVG + " Selection sort avg: " + selAVG);
		
		
		
	}

	
	public static double[] RandomArray(int N, Random R) //returns a random double array
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
	
	public static void PrintDoubleArray(double[] array) //prints array
	{
		for(int i = 0; i < array.length; i++)
		{
			//print with comma until last value
			if(i < array.length - 1)
			{
				System.out.print(array[i] + ",");
			}
			else
			{
				System.out.print(array[i]);
			}
		}
	}
	
	public static boolean preSorted(double [] array) //returns true if array is sorted 
	{       
	    for (int i = 1; i < array.length; i++)
	    {
	    	if(array[i-1] > array[i])
	    	{
	    		return false;
	    	}
	    }
	    return true;
	}
	
	public static int selSort(double[] array) //sorts using selection sort, returns number of compares
	{
		int comp = 0;
		for (int i=0; i <array.length - 1; i++) 
		{
	        for (int k= i + 1; k < array.length; k++) 
	        {
	            if (array[i] > array[k]) 
	            {
	                double temp = array[i];
	                array[i] = array[k];
	                array[k] = temp;
	            }
	            comp++;
	        }
	    }
		return comp;
	}
	
	public static int inSort(double[] array) //sorts with insertion sort, returns number of compares
	{
		int comp = 0;
	    for (int i = 1; i < array.length; i++) 
	    {
	    	double temp = array[i];
	    	int k;
	    	for(k = i - 1; k > -1 && temp < array[k]; k--)
	    	{
	    		array[k + 1] = array[k];
	    		comp++;
	    	}
	    	array[k + 1] = temp;
	    	comp++;
	    }
	    return comp;
	}
	
}
