import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class graph
{
	private LinkedList <Integer> [] vert; 
	private int vNum;
	private int eNum;

	
	public graph(int numVerts)
	{
		this.vNum = numVerts;
		this.vert = new LinkedList[numVerts];
		
		for(int i = 0; i < numVerts; i++)
		{
			this.vert[i] = new LinkedList <Integer>();
		}
	}
	
	public void addVert(int v, int w) throws Exception
	{
		
		//if(v > vNum - 1 || w > vNum - 1)
		//{
		//	throw new Exception("Input out of bounds, exitting.");
		//}
		this.vert[v].add((Integer)w);
		this.vert[w].add((Integer)v);
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
	
	public boolean isConnected(int v, int w)
	{
		DFS test = new DFS(this);
		test.dfs(v);
		
		return test.connected(v, w);
	}
	
	public LinkedList <Integer> path(int v, int w) throws PathNotFound
	{
		DFS test = new DFS(this);
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
	
	public boolean adjacent(int v, int w)
	{
		LinkedList<Integer> test = this.getAdjacent(v);
		
		for(int i : test)
		{
			if(i == w)
			{
				return true;
			}
		}
		return false;
	}
	
	public LinkedList <Integer> shortestPath(int v, int w) throws PathNotFound
	{
		BFS test = new BFS(this);
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
	
	public LinkedList<LinkedList<Integer>> getConnectedComponents()
	{
		LinkedList <LinkedList<Integer>> comps = new LinkedList<LinkedList<Integer>>();
		DFS se = new DFS(this);
		
		se.dfs(0);
		boolean [] v = se.getvisit();
		LinkedList <Integer> temp = new LinkedList<Integer>();
		for(int k = 0; k < v.length; k++)
		{
			
			if(v[k])
			{
				temp.add(k);
			}
			else
			{
				LinkedList <Integer> temp2 = new LinkedList<Integer>();
				DFS se2 = new DFS(this);
				se2.dfs(k);
				boolean [] v2 = se2.getvisit();
				
				for(int l = 0; l < v2.length; l++)
				{
					if(v2[l])
					{
						temp2.add(l);
					}
				}
				if(temp2.size() > 0)
				{
					comps.add(temp2);
				}
			}
			
		}
		comps.add(temp);
		return comps;
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
	
	public int getVertNum()
	{
		return vNum;
	}
	
	public LinkedList<Integer> getVert(int v)
	{
		return this.vert[v];
	}
	
	public LinkedList<Integer> getAdjacent(int v) //named it wrong, didn't want to change everything
	{
		return getVert(v);
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
	
	public static graph readGraph(String fileName) throws Exception
	{
		BufferedReader in = null;
		graph temp = null;
		
		try
		{
			in = new BufferedReader(new FileReader(fileName));
			
			String line = "";
			line = in.readLine();
			if(!line.equals(null))
			{
				temp = new graph(Integer.parseInt(line));
			}
			//else
			//{
			//	throw new Exception("File is not formatted properly.");
			//}
			
			while ((line = in.readLine()) != null)
			{

				
				int sep = line.indexOf(',');
				//parse it
				int p1 = Integer.parseInt(line.substring(0, sep));
				int p2 = Integer.parseInt(line.substring(sep + 1));
				
				temp.addVert(p1, p2);
				
				//check if already exists - shouldn't do this
				//if(!(temp.vert[p1].contains(p2)|| temp.vert[p2].contains(p1)))
				//{
				//	temp.addVert(p1, p2);
				//}
				
				//check if already exists
				
			}

			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if (in != null)in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return temp;
	}
	
	
	

}
