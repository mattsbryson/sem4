import java.util.Iterator;

public class MyArrayListIterator<T> implements Iterator<T> {

	private MyArrayList<T> list;
	private int n;

	public MyArrayListIterator(MyArrayList<T> l) {
		list = l;
		n = 0;
	}

	public boolean hasNext() {
		return n < this.list.size();
	}

	public T next() {
		T result = this.list.get(n);
		n++;
		return result;
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
