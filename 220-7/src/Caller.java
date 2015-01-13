import java.util.Iterator;


public class Caller {

	public static void main(String[] args) 
	{
		//question 1
		
		MyArrayList<Integer> l = new MyArrayList<Integer>();
		l.add(3);
		l.add(5);
		l.add(7);
		l.add(9);
		l.add(11);
		for(Integer x : l)
		{
			System.out.println(x);
		}

		Iterator i = l.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		
		//end of question 1
		
		//question 3
		MyLinkedList<Integer> m = new MyLinkedList<Integer>();
		m.add(3);
		m.add(5);
		m.add(7);
		m.add(9);
		m.add(11);
		for(Integer x : m)
		{
			System.out.println(x);
		}
		
		Iterator z = m.iterator();
		while(z.hasNext())
		{
			System.out.println(z.next());
		}
		
		

	}

}
