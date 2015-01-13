import java.util.ArrayList;


public class MyArrayListCaller {

	public static void main(String[] args) 
	{
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		
	
		list.add(1);
		list.add(2);
		list.add(4);
		list.delete(1);
		
		System.out.print(list.toString());

		
		
	}

}
