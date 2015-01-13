import java.util.Scanner;


public class PrimeNumbers {

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		
		int num = reader.nextInt();
		
		for(int i = num - 1; i > 1; i--)
		{
			if(num % i == 0)
			{
				System.out.println("The number is not prime.");
				System.exit(0);
			}			
		}
		System.out.println("The number is prime");

	}

}
