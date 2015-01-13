import java.util.Iterator;
import java.util.LinkedList;


public class SeperateChainingHashMap <Key, Value> 
{
	private int m;
	private LinkedList <HashNode> [] map;		
			
	public SeperateChainingHashMap()
	{
		this(10007);
	}
	
	public SeperateChainingHashMap(int buckets)
	{
		this.m = buckets;
		this.map = new LinkedList [m];
		for(int i = 0; i < m; i++)
		{
			this.map[i] = new LinkedList();
		}
	}
	
	public Value getValue(Key key)
	{
		int b = Math.abs(key.hashCode()) % m;
		Iterator i = this.map[b].iterator();
		while(i.hasNext())
		{
			HashNode temp = (HashNode) i.next();
			Key ke =  (Key) temp.getKey();
			if(ke.equals(key))
			{
				return (Value) temp.getValue();
			}
		}
		return null;
	}
	
	public void put(Key key, Value value)
	{
		int b = Math.abs(key.hashCode()) % m;
		//not sure this is the most efficient way to support "chaining" 
	
		if(!(this.map[b].size() == 0))
		{
			int r = 0;
			Iterator i = this.map[b].iterator();
			while(i.hasNext())
			{
				HashNode temp = (HashNode) i.next();
				Key ke =  (Key) temp.getKey();
				if(ke.equals(key))
				{
					this.map[b].remove(r);
					break;
				}
				r++;
			}
		}
		this.map[b].add(new HashNode((Key) key, (Value)value));
	}
	
	public void put(HashNode n)
	{
		int b = Math.abs(n.getKey().hashCode()) % m;
		//not sure this is the most efficient way to support "chaining" 
	
		if(!(this.map[b].size() == 0))
		{
			int r = 0;
			Iterator i = this.map[b].iterator();
			while(i.hasNext())
			{
				HashNode temp = (HashNode) i.next();
				Key ke =  (Key) temp.getKey();
				if(ke.equals(n.getKey()))
				{
					this.map[b].remove(r);
					break;
				}
				r++;
			}
		}
		this.map[b].add(new HashNode((Key) n.getKey(), (Value)n.getValue()));
	}
	
	public boolean containsKey(Key key)
	{
		int b = Math.abs(key.hashCode()) % m;
		Iterator i = this.map[b].iterator();
		while(i.hasNext())
		{
			HashNode temp = (HashNode) i.next();
			Key ke =  (Key) temp.getKey();
			if(ke.equals(key))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public int size()
	{
		int sum = 0; 
		for(int i = 0; i < m; i++)
		{
			sum += this.map[i].size();
		}
		return sum;
	}
	
	public boolean isEmpty()
	{
		if(size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int shortLength()
	{
		int s = this.map[0].size();
		
		for(int i = 0; i < m; i++)
		{
			if(s > this.map[i].size())
			{
				s = this.map[i].size();
			}
		}
		return s;
	}
	
	public int longLength()
	{
		int l = this.map[0].size();
		
		for(int i = 0; i < m; i++)
		{
			if(l < this.map[i].size())
			{
				l = this.map[i].size();
			}
		}
		return l;
	}
	
	public double avgLength()
	{
		double avg = 0;
		for(int i = 0; i < m; i++)
		{
			avg += this.map[i].size();
		}
		return avg/m;
	}
	
	//wrote this for fun
	public void resize(int n)
	{
		int o = m;
		this.m = n;
		LinkedList <HashNode>[] old = this.map;
		this.map = new LinkedList[m];
		
		for(int i = 0; i < m; i++)
		{
			this.map[i] = new LinkedList();
		}
		
		for(int i = 0; i < o; i++)
		{
			for(HashNode k : old[i])
			{
				this.put(k);
			}
		}
	}
	
	public void resize()
	{
		this.resize(this.size() * 4);
	}
	
}
