public class BSTNode<Key, Value> {

	private Key key;

	private Value value;

	private BSTNode<Key, Value> left;

	private BSTNode<Key, Value> right;

	public BSTNode(Key key, Value value, BSTNode<Key, Value> left,BSTNode<Key, Value> right)
	{

		super();

		this.key = key;

		this.value = value;

		this.left = left;

		this.right = right;

	}

	public Key getKey()

	{

		return key;

	}

	public Value getValue()

	{

		return value;

	}

	public void setValue(Value value) {

		this.value = value;

	}

	public BSTNode<Key, Value> getLeft() {

		return left;

	}

	public BSTNode<Key, Value> getRight() {

		return right;

	}

	public void setLeft(BSTNode<Key, Value> left) {

		this.left = left;

	}

	public void setRight(BSTNode<Key, Value> right) {

		this.right = right;

	}

}
