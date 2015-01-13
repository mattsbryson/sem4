import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Graph
{
	
	private int vNum;
	private AdjacencyList list; 
	

	public Graph(int numVerts)
	{
		this.vNum = numVerts;
		list = new AdjacencyList(numVerts);
	}
	
	public AdjacencyList getList()
	{
		
		return this.list;
	}
	
	public int getVertNum()
	{
		return vNum;
	}
	
	public LinkedList <Integer> getVert(int v)
	{
		return list.getVert(v);
	}

	
	
	
	public boolean isConnected(int v, int w)
	{
		DFS test = new DFS(this.getList());
		test.dfs(v);
		
		return test.connected(v, w);
	}
	
	public boolean adjacent(int v, int w)
	{
		LinkedList<Integer> test = this.list.getAdjacent(v);
		
		for(int i : test)
		{
			if(i == w)
			{
				return true;
			}
		}
		return false;
	}
	
	
	public LinkedList <Integer> path(int v, int w) throws PathNotFound
	{
		DFS test = new DFS(this.getList());
		test.dfs(v);
		LinkedList <Integer> path = new LinkedList<Integer>();
		
		int [] edgeTo = test.getEdgeTo();
		
		if(test.connected(v, w))
		{
			path.add(v);
			int next = edgeTo[v];
			while(next != w)
			{
					path.add(next);
					next = edgeTo[next];
			}
			path.add(w);
		}
		else
		{
			throw new PathNotFound();
		}
		return path;
	}
	
	public LinkedList <Integer> shortestPath(int v, int w) throws PathNotFound
	{
		BFS test = new BFS(this.getList());
		test.bfs(v);
		LinkedList <Integer> path = new LinkedList<Integer>();
		int [] edgeTo = test.getEdgeTo();
		
		if(test.connected(v, w))
		{
			path.add(v);
			int next = edgeTo[v];
			while(next != w)
			{
				path.add(next);
				next = edgeTo[next];
			}
			path.add(w);
		}
		else
		{
			throw new PathNotFound();
		}
		return path;
	}

	
	
}
