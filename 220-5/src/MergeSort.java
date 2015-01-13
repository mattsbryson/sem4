import java.util.Random;
import java.util.Scanner;


public class MergeSort {

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.print("Please enter the size of N you would like: ");
		int N = reader.nextInt();
		double mCompare = 0;
		double mCopy = 0;
		Random gen = new Random();
		int [] cNc = new int[2]; // 0 is compare, 1 is copy 
		
		for(int i = 0; i < 100; i++)
		{
			double [] arr1 = RandomArray(N, gen);
			//double [] arr1 = {0,1,2,3,4,5,6};
			//double [] arr2 = {0,1,2,3,4,5,6};
			mergeSort(arr1, cNc);
			mCompare += cNc[0];
			mCopy += cNc[1];
			cNc[0] = 0;
			cNc[1] = 0;
 			if(!(preSorted(arr1)))
			{
				System.err.println("The array was not sorted. Stopping program.");
				System.exit(0);
			}
			//PrintDoubleArray(arr1);
		}
		
		mCompare /= 100;
		mCopy /= 100;
		
		System.out.println("Average Compares: " + mCompare + " Average Copies: " + mCopy);

	}
	
	
	//copied from book, with a little modification 
	public static int[] mergeSort(double[] list, int [] cNc) 
	{
	    if (list.length > 1) {
	      // Merge sort the first half
	      double[] firstHalf = new double[list.length / 2];
	      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
	      cNc[1] += firstHalf.length;
	      mergeSort(firstHalf, cNc);

	      // Merge sort the second half
	      int secondHalfLength = list.length - list.length / 2;
	      double[] secondHalf = new double[secondHalfLength];
	      System.arraycopy(list, list.length / 2,
	      secondHalf, 0, secondHalfLength);
	      cNc[1] += firstHalf.length;
	      mergeSort(secondHalf, cNc);

	      // Merge firstHalf with secondHalf into list
	      cNc[0] += merge(firstHalf, secondHalf, list);
	      cNc[0]++; //for loop
	    }
	    return cNc; 
	  }

	  /** Merge two sorted lists */
	  public static int merge(double[] list1, double[] list2, double[] temp) 
	  {
		int comp = 0;
	    int current1 = 0; // Current index in list1
	    int current2 = 0; // Current index in list2
	    int current3 = 0; // Current index in temp

	    while (current1 < list1.length && current2 < list2.length) 
	    {
	      if (list1[current1] < list2[current2])
	        temp[current3++] = list1[current1++];
	      else
	        temp[current3++] = list2[current2++];
	      comp += 2; //for the while loop and the if
	    }
	    

	    while (current1 < list1.length)
	    {
	    	temp[current3++] = list1[current1++];
	    	comp++; //for the loop
	    }
	      

	    while (current2 < list2.length)
	    {
	    	temp[current3++] = list2[current2++];
	    	comp++; //for the loop
	    }
	      
	    return comp;
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

}
