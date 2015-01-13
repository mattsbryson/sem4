
public class MergeSort 
{


	public static long fact(long n)
	{
		if(n == 0)
		{
			return 1;
		}
		else
		{
			return n * fact(n-1);
		}
	}
	
	 public static void mergesort(int[ ] data, int first, int n)
	   {
	      int n1; // Size of the first half of the array
	      int n2; // Size of the second half of the array

	      if (n > 1)
	      {
	         // Compute sizes of the two halves
	         n1 = n / 2;
	         n2 = n - n1;

	         mergesort(data, first, n1);      // Sort data[first] through data[first+n1-1]
	         mergesort(data, first + n1, n2); // Sort data[first+n1] to the end

	         // Merge the two sorted halves.
	         merge(data, first, n1, n2);
	      }
	   } 
	 
	 
	   private static void merge(int[ ] data, int first, int n1, int n2)
	   // Precondition: data has at least n1 + n2 components starting at data[first]. The first 
	   // n1 elements (from data[first] to data[first + n1 Ð 1] are sorted from smallest 
	   // to largest, and the last n2 (from data[first + n1] to data[first + n1 + n2 - 1]) are also
	   // sorted from smallest to largest. 
	   // Postcondition: Starting at data[first], n1 + n2 elements of data
	   // have been rearranged to be sorted from smallest to largest.
	   // Note: An OutOfMemoryError can be thrown if there is insufficient
	   // memory for an array of n1+n2 ints.
	   {
	      int[ ] temp = new int[n1+n2]; // Allocate the temporary array
	      int copied  = 0; // Number of elements copied from data to temp
	      int copied1 = 0; // Number copied from the first half of data
	      int copied2 = 0; // Number copied from the second half of data
	      int i;           // Array index to copy from temp back into data

	      // Merge elements, copying from two halves of data to the temporary array.
	      while ((copied1 < n1) && (copied2 < n2))
	      {
	         if (data[first + copied1] < data[first + n1 + copied2])
	            temp[copied++] = data[first + (copied1++)];
	         else
	            temp[copied++] = data[first + n1 + (copied2++)];
	      }

	      // Copy any remaining entries in the left and right subarrays.
	      while (copied1 < n1)
	         temp[copied++] = data[first + (copied1++)];
	      while (copied2 < n2)
	         temp[copied++] = data[first + n1 + (copied2++)];

	      // Copy from temp back to the data array.
	      for (i = 0; i < n1+n2; i++)
	         data[first + i] = temp[i];
	   }
	   
	
	
	

}