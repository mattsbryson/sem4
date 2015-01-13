import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class UndirectedGraph extends Graph
{
	
	public UndirectedGraph(int numVerts)
	{
		super(numVerts);
	}
	
	public void addEdge(int v, int w)
	{
		try
		{
			super.getList().addVert(false, v, w);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getNumVertices()
	{
		return super.getVertNum();
	}
	
	public LinkedList<Integer> getAdjacent(int v)
	{
		return super.getList().getAdjacent(v);
	}

	boolean isAdjacent(int v, int w)
	{
		return super.adjacent(v, w);
	}
	
	//isConnected is in superclass
	
	//path is in super

	//shortPath is in super
	
	public int degree(int v)
	{
		return super.getList().getVert(v).size();
	}
	
	
	public LinkedList<LinkedList<Integer>> getConnectedComponents()
	{
		LinkedList <LinkedList<Integer>> comps = new LinkedList<LinkedList<Integer>>();
		DFS se = new DFS(this.getList());
		
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
				DFS se2 = new DFS(this.getList());
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
	
	
	public static UndirectedGraph readGraph(String fileName) throws Exception
	{
		BufferedReader in = null;
		UndirectedGraph temp = null;
		
		try
		{
			in = new BufferedReader(new FileReader(fileName));
			
			String line = "";
			line = in.readLine();
			if(!line.equals(null))
			{
				temp = new UndirectedGraph(Integer.parseInt(line));
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
				
				temp.getList().addVert(false, p1, p2);
				
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
