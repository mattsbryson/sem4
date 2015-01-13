//	T is the type of the list elements

public class MyArrayList<T> {

	private static final int INITIAL_SIZE = 4;

	private T[] elements;
	private int numElts;

	public MyArrayList(int initialSize) {
		this.elements = (T[]) new Object[initialSize];
		this.numElts = 0;
	}

	public MyArrayList() {
		this(INITIAL_SIZE);
	}
	
	/**
	 * Add an element to the end of a list.
	 * 
	 * @param elt -- the element being added.
	 */

	public void add(T elt) {
		if (this.numElts == this.elements.length) {
			// resize the arraya
			T temp[] = (T[]) new Object[this.elements.length * 2];
			for (int i = 0; i < this.elements.length; i++) {
				temp[i] = this.elements[i];
			}
			this.elements = temp;
		}

		this.elements[numElts] = elt;
		this.numElts++;
	}

	/**
	 * Gets an element from a given list index (indices number from zero).
	 * @param i -- the index
	 * @return the element at position i in the list.
	 */
	
	public T get(int i) {
		return this.elements[i];
	}

	public int size() {
		return this.numElts;
	}

	public boolean isEmpty() {
		return this.numElts == 0;
	}	
	
	public void delete(int i)
	{
		if(i > this.numElts)
		{
			System.err.println("This is not a valid element.");
			System.exit(0);
		}
		
		for(int k = i; k < this.numElts -1; k++)
		{
			this.elements[k] = this.elements[k+1];
		}
		this.numElts--;
	}
	
	public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append("[");
        for (int i = 0; i < numElts; i++) 
        {
        	if(i < numElts - 1)
        	{
        		temp.append(this.elements[i].toString() + ",");
        	}
        	else
        	{
        		temp.append(this.elements[i].toString());
        	}
        }
        temp.append("]");
        return temp.toString();
   }

}
