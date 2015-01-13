import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>
{

	private Node<T> head;

	private Node<T> tail;

	private int numElts;

	public MyLinkedList() 
	{
		head = null;
		tail = null;
		numElts = 0;
	}	

	public void add(T elt) 
	{
		Node<T> node = new Node<T>(elt, null);
		if (this.head == null) 
		{
			this.head = node;
			this.tail = node;
		} 
		else 
		{
			this.tail.setNext(node);
			this.tail = node;
		}
		numElts++;
	}

	public void delete(int i) 
	{
		if (i == 0) 
		{
			// single element list
			if (head == tail) 
			{
				head = null;
				tail = null;
			} 
			else 
			{
				head = head.getNext();
			}
		} 
		else 
		{
			// i != 0
			Node<T> prev = null;
			Node<T> node = head;
			int j = 0;
			while (j != i) 
			{
				j++;
				prev = node;
				node = node.getNext();
			}
			prev.setNext(node.getNext());
			if(node == tail)
				tail = prev;
		}
		numElts--;
	}

	public int size() 
	{
		// Node<T> node = head;
		
		// int i = 0;
		
		// while (node != null) {
		
		// i++;
		
		// node = node.getNext();
		
		// }
		
		//
		
		// return i;
		
		return numElts;
	}

	public boolean isEmpty() 
	{

		return head == null;

	}


	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		Node<T> node = head;
		while(node != null)
		{
			builder.append(node.getElement().toString());
			if(node != tail)
				builder.append(", ");
			node = node.getNext();
		}

		builder.append("]");

		return builder.toString();
	
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new MyLinkedListIterator<T>(this, head);
	}

}