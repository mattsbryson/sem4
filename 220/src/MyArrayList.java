//practice arraylist class 2-26-14
public class MyArrayList<T> 
{
	private static final int INITIAL_SIZE = 10;
	private int[] elements; 
	private int numElts;
	
	public MyArrayList()
	{
		this.elements = new int[INITIAL_SIZE];
		numElts = 0;
	}
	
	public void add(int elt)
	{
		if(this.numElts == this.elements.length)
		{
			//resize the array
			int temp[] = new int[this.elements.length + 10];
			for(int i = 0; i < this.elements.length; i++)
			{
				temp[i] = this.elements[i];
			}
			this.elements = temp;
		}
		
		
		this.elements[this.numElts] = elt;
		this.numElts++;
	}
}
