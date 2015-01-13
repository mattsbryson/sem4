import java.util.LinkedList;


public class AdjacencyList
{
	private LinkedList <Integer> [] vert; 
	private int vNum;
	
	
	public AdjacencyList(int numVerts)
	{
		this.vNum = numVerts;
		this.vert = new LinkedList[numVerts];
		
		for(int i = 0; i < numVerts; i++)
		{
			this.vert[i] = new LinkedList <Integer>();
		}
	}
	
	public int getVertNum()
	{
		return vNum;
	}
	
	public void addVert(boolean directed, int v, int w) throws Exception
	{
		
		//if(v > vNum - 1 || w > vNum - 1)
		//{
		//	throw new Exception("Input out of bounds, exitting.");
		//}
		if(directed)
		{
			this.vert[v].add((Integer)w);
			this.vert[w].add((Integer)v);
		}
		else
		{
			this.vert[v].add((Integer)w);
		}
	}
	
	public LinkedList<Integer> getVert(int v)
	{
		return this.vert[v];
	}
	
	public int getEdgeNum()
	{
		int count = 0; 
		for(int i = 0; i < vert.length; i++)
		{
			for(int k : vert[i])
			{
				count++;
			}
		}
		return count/2;
	}
	
	public LinkedList<Integer> getAdjacent(int v) //named it wrong, didn't want to change everything
	{
		return getVert(v);
	}
	
	public boolean isAdjacent(int v, int w)
	{
		boolean temp = false;
		
		for(int i : vert[v])
		{
			if(i == w)
			{
				temp = true;
			}
		}
		//don't need to check the other part of the list 
		
		return temp;
	}
	
	public String toString()
	{
		String out = "";
		for(int i = 0; i < this.vert.length; i++)
		{
			out += i + ": ";
			for(Integer k : this.vert[i])
			{
				 out += k + ","; //not great formatting, but oh well
			}
			out+= "\n";
		}
		return out;
	}
	
	
	
	
}
