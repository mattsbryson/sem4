import java.util.Scanner;


public class Palindrome {

	public static void main(String[] args) 
	{
		Scanner r = new Scanner(System.in);
		System.out.print("Please enter a sequence of numbers: ");
		String temp = r.next();
		int [] seq = new int [temp.length()];
		
		
		
		for(int i = 0; i < temp.length(); i++)
		{
			seq[i] = Integer.parseInt(temp.charAt(i) + "");
		}
		
		int y = 0;
		for(int i = seq.length - 1; i > 0; i--)
		{
			if(seq[i] != seq[y])
			{
				System.out.println("Not a palindrome");
				System.exit(0);
			}
			y++;
		}
		System.out.println("This is a palindrome.");

	}

}
