import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS
{
	private graph g;
	private boolean[] visit;
	private int[] edgeTo;

	// private Stack<Integer> path;
	public DFS(graph g)
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