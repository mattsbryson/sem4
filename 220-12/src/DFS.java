import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS
{
	private AdjacencyList g;
	private boolean[] visit;
	private int[] edgeTo;
	LinkedList<Integer> tSort;

	// private Stack<Integer> path;
	public DFS(AdjacencyList g)
	{
		this.g = g;
		this.visit = new boolean[g.getVertNum()];
		this.edgeTo = new int [g.getVertNum()];
	}

	public void setEverythingFalse()
	{
		for (int i = 0; i < this.visit.length; i++)
		{
			this.visit[i] = false;
		}
	}

	public void dfs(int v)
	{
		for (int a : g.getVert(v))
		{
			this.visit[v] = true;
			if (!this.visit[a])
			{
				//System.out.println("V:" + v + ", A:" + a);
				edgeTo[v] = a;
				
				dfs(a);
			}
		}
	}
	
	public LinkedList <Integer> topoSort()
	{
		this.tSort = new LinkedList<Integer>();
		for(int v = 0; v < g.getVertNum(); v++)
		{
			for (int a : g.getVert(v))
			{
				this.visit[v] = true;
				if (!this.visit[a])
				{
					
					tSort.push(a);
					dfs(a);
				}
			}
		}
		return tSort;
	}
	
	public void tSortHelper(int v)
	{
		for (int a : g.getVert(v))
		{
			this.visit[v] = true;
			if (!this.visit[a])
			{
				
				tSort.push(a);
				dfs(a);
			}
		}
	}

	public boolean[] getvisit()
	{
		return visit;
	}

	public boolean connected(int a, int b)
	{
		dfs(a);

		return (visit[a] && visit[b]);
	}

	
	public int [] getEdgeTo()
	{
		return edgeTo;
	}
	
	
	
}