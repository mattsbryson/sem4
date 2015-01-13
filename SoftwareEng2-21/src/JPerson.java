import java.util.Scanner;


public class JPerson 
{
	final int FirstNameSpaces = 15; //fixed length of firstname
	final int MiddleNameSpaces = 15; //fixed length of middlename
	final int LastNameSpaces  = 20; //fixed length of lastname 
	
	public JPerson(){}
	
	public void InputValues()
	{
		Scanner read = new Scanner(System.in);
		System.out.print("\n\t\tGive me a name    : ");
		FirstName = read.nextLine();
		System.out.print("\n\t\tGive me a name    : ");
		MiddleName = read.nextLine();
		System.out.print("\n\t\tGive me a name    : ");
		LastName = read.nextLine();
		
		//if you generated your names via permutation 
		//you will have to format the fields 
		
		FormatFields();
	}
	
	public void FormatFields()
	{
		int k; //Transient variable
		String Buffer; //Transient variable
		char Spaces; //Transient variableand 
		
		Spaces = 32; //alpha-numeric value of a space
		
		//create a buffer space for FirstName
		Buffer = ""; //initialize buffer with nothing
		for(k = 0; k < FirstNameSpaces; k++)
		{
			Buffer += Spaces;
		}
		
		FirstName = FirstName + Buffer; 
		FirstName = FirstName.substring(0, FirstNameSpaces);  //guarantees 15-byte length 
		
		//create a buffer space for MiddleName
		
		Buffer = "";       //initialize buffer with nothing
		for  ( k = 0; k < MiddleNameSpaces; k++)
		{
			Buffer += Spaces;
		}
		
		MiddleName = MiddleName + Buffer;
		MiddleName = MiddleName.substring(0,MiddleNameSpaces);   //guarantees a 15-byte length
		
		//create a buffer space for LastName
		
		Buffer = "";   //initialize buffer with nothing
		for ( k = 0; k < LastNameSpaces; k++)
		{
			Buffer += Spaces;
		}
		
		LastName = LastName + Buffer;
		LastName = LastName.substring(0,LastNameSpaces);    //guarantees a 20-byte length
		
		
		System.out.println("\n\tRecord = 12345678901234567890123456789012345678901234567890");
		System.out.println("\n\tRecord = " + FirstName+MiddleName+LastName+ "X");
	}
	
	public void GenerateSSN()
	{
		final int SSNSize = 1000000000; //In USA, This is A9-Digit field 
		final String SSNTrailer = "0000000000"; //usa uses 9 digit field 
		
		int BufferSSN; 	//transient variables
		String SSNHolder; //transient vairbales
		int k; 			//transient variables 
		
		BufferSSN = (int) Math.random()*SSNSize;
		SSNHolder = SSNTrailer + BufferSSN;
		
		k = SSNHolder.length();
		
		SSNHolder = SSNHolder.substring((k - 9), k);
		SocialSecurityNumber = SSNHolder.substring(0,3) +"-";
		SocialSecurityNumber = SSNHolder.substring(3, 5) + "-";
		SocialSecurityNumber = SSNHolder.substring(5);		
	}
	
	
	//private member variables
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String SocialSecurityNumber;
}
