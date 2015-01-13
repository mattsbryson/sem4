import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
public class test 
{
	public static void doSomething() throws Exception
	{
		File r = new File("test");
		
		BufferedReader re = new BufferedReader(new FileReader("C:\\Users\\Matt\\Google Drive\\Code\\Sem4\\220\\src\\test"));
		
		System.out.println(re.readLine());
		
		
		
		
		// some code that throws an Exception
	}

	public static void main(String[] args) 
	{
		try 
		{
			doSomething();
		} 
		catch (FileNotFoundException ex) 
		{
			System.out.print("1");
			int k = 6/0;
		}
		catch (IOException ex) 
		{
			System.out.print("2");
		} 
		catch (Exception ex) 
		{
			System.out.print("3");
		}
		finally
		{
			System.out.print("4");
		
		}
	}
}