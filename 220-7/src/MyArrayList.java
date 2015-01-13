import java.util.Arrays;

public class MyArrayList<T> implements Iterable<T>{
	/*
	 * 
	 * == - Compares if it is the same object? Is it the same thing in the
	 * memory. So no,
	 * 
	 * one MyArrayList cannot be null, otherwise we cannot call the methods.
	 * 
	 * this is an instance of class MyArrayList (or subclass of myarraylist)
	 */

	private static final int INITIAL_SIZE = 10;

	public T[] elements;
	public int numElts;

	public MyArrayList() {
		elements = (T[]) new Object[INITIAL_SIZE];
		numElts = 0;
	}

	public void add(T elt) {
		if (this.numElts == this.elements.length) {
			T[] temp = (T[]) new Object[this.elements.length + 10];
			for (int i = 0; i < elements.length; i++) {
				temp[i] = this.elements[i];
			}
			this.elements = temp;
		}

		elements[numElts] = elt;
		numElts++;
	}

	/**
	 * Gets an element from a given list index
	 * 
	 * @param i
	 *            - the index
	 * @return the element at position i in the list.
	 */

	
	public T get(int i) {
		if(i >= numElts || i < 0){
			throw new IndexOutOfBoundsException( i + "");
		}
		else{
		return this.elements[i];
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(elements);
		result = prime * result + numElts;
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		// If it is the same object
		if (this == obj)
			return true;

		// Cannot compare to a null value
		if (obj == null)
			return false;

		// The class of each object has to be the same
		if (getClass() != obj.getClass())
			return false;
		// know that this and obj are sub-classes of MyArrayList

		MyArrayList other = (MyArrayList) obj;

		if (numElts != other.numElts)
			return false;

		for (int i = 0; i < this.numElts; i++) {
			if (!this.elements[i].equals(other.elements[i])) {
				return false;
			}
		}

		return true;
	}

	public boolean deleteElement(Integer toBeDeleted) {
		if (toBeDeleted > numElts) {

			System.err.println(toBeDeleted + " doesn't exist");
			return false;

		}

		for (int j = toBeDeleted; j < numElts - 1; j++) {
			this.elements[j] = this.elements[j + 1];
		}
		numElts--;
		return true;
	}

	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("[ ");

		for (int i = 0; i < numElts; i++) {
			builder.append(this.elements[i].toString());
			if (i != numElts - 1)
				builder.append(", ");
		}

		builder.append(" ]");

		return builder.toString();
	}
	
	private void resizeIfNeedBy(){
		if(this.numElts == this.elements.length){
			T temp[] = (T[]) new Object[this.elements.length * 2];
			for(int i =0; i < this.elements.length; i++){
				temp[i] = this.elements[i];
			}
			
			this.elements = temp;
		}
	}
	
	
	public void addFirst(T elt){
		this.resizeIfNeedBy();
		for(int i = numElts -1; i >= 0; i--){
			this.elements[1 + i] = this.elements[i];
		}
		
		this.elements[0] = elt;
		numElts++;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return numElts;
	}
	public MyArrayListIterator<T> iterator(){
		return new MyArrayListIterator<T>(this);
	}

}