import java.util.Iterator;

public class MyLinkedListIterator<T> implements Iterator<T> {

	private MyLinkedList<T> list;
	private Node n;

	public MyLinkedListIterator(MyLinkedList<T> l, Node head) 
	{
		list = l;
		n = head;

	}

	public boolean hasNext() 
	{
		if(n == null)
		{
			return false;
		}
		
		else
		{
			return true;
		}
	}

	public T next() 
	{
		T temp = (T) n.getElement();
		n = n.getNext();

		return temp;
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
