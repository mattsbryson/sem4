import java.util.Random;

public class BST<Key extends Comparable<Key>, Value>
{

	private BSTNode<Key, Value> root;

	public BST()
	{

		super();

		root = null;

	}

	private void put(BSTNode<Key, Value> current, Key key, Value value)
	{

		// key "equals" current.getKey()

		if (key.compareTo(current.getKey()) == 0)
		{

			current.setValue(value);

		}

		// key "greater than" current.getKey()

		else if (key.compareTo(current.getKey()) > 0)
		{

			if (current.getRight() == null)

				current.setRight(new BSTNode<Key, Value>(key, value, null, null));

			else

				put(current.getRight(), key, value);

		} 
		else
		// key "less than" current.getKey()
		{

			if (current.getLeft() == null)

				current.setLeft(new BSTNode<Key, Value>(key, value, null, null));

			else

				put(current.getLeft(), key, value);

		}

	}

	public void put(Key key, Value value)
	{

		if (root == null)
		{

			root = new BSTNode<Key, Value>(key, value, null, null);

		} else
		{

			put(root, key, value);

		}

	}

	private Value get(BSTNode<Key, Value> current, Key key)
	{

		// key not in the tree

		if (current == null)

			return null;

		// key "equals" current.getKey()

		else if (key.compareTo(current.getKey()) == 0)
		{

			return current.getValue();

		}

		// key "greater than" current.getKey()

		else if (key.compareTo(current.getKey()) > 0)
		{

			return get(current.getRight(), key);

		}

		else
		// key "less than" current.getKey()

		{

			return get(current.getLeft(), key);

		}

	}

	public Value get(Key key)
	{

		return get(root, key);

	}
	
	public int getSize(BSTNode temp) //returns the total number of nodes - please note, not the depth 
	{
		if(temp == null)
			return 0;
		else
		{
			return getSize(temp.getLeft()) + getSize(temp.getRight()) + 1;	
		}
	}
	
	public int getSize() //returns the total number of nodes - please note, not the depth - this is for root
	{
		if(root == null)
			return 0;
		else
		{
			return getSize(root);	
		}
	}
	
	public int getDepth(BSTNode temp)
	{
		if(temp == null)
			return 0;
		else if(getDepth(temp.getLeft()) > getDepth(temp.getRight()))
		{
			return getDepth(temp.getLeft()) + 1;
		}
		else
		{
			return getDepth(temp.getRight()) + 1;
		}
	}
	
	public int getDepth()
	{
		if(root == null)
		{
			return 0;
		}
		else if(getDepth(root.getLeft()) > getDepth(root.getRight()))
		{
			return getDepth(root.getLeft()) + 1;
		}
		else
		{
			return getDepth(root.getRight()) + 1;
		}
	}
	
	public static BST random(int n)
	{
		BST temp = new BST();
		Random gen = new Random();
		for(int i = 0; i < n; i++)
		{
			temp.put(gen.nextInt(), null);
		}
		return temp;
	}
	

}