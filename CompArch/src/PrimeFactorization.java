import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization
{
	
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.print("Please enter the number that you would like to factor: ");
		
		int num = reader.nextInt();
		int [] factors = primeFactors(num);
		
		for(int i = 0; i < factors.length && factors[i] != 0; i++)
		{
			System.out.print(factors[i] + " ");
		}
		
		
		
	}
	
	
	public static int [] primeFactors(int n) 
	{
		int[] factors = new int [8];
		int y = 0;
		for (int i = 2; i < n + 1; i++) 
		{
			while (n % i == 0)
			{
				factors[y] = i;
				y++;
				n /= i;
			}
		}
		return factors;
	}

	
} 