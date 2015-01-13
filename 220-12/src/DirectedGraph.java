import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class DirectedGraph extends Graph
{

	
	
	public DirectedGraph(int numVerts)
	{
		super(numVerts);
		// TODO Auto-generated constructor stub
	}

	
	public void addEdge(int v, int w)
	{
		try
		{
			super.getList().addVert(true, v, w);
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
	
	
	public int inDegree(int v)
	{
		int sum = 0;
		for(int i = 0; i < super.getVertNum(); i++)
		{
			if(this.isAdjacent(v, i))
			{
				sum++;
			}
		}
		return sum;
	}
	
	public int outDegree(int v)
	{
		return super.getList().getVert(v).size();
	}
	
	
	public LinkedList<Integer> topologicalOrderByKahn()
	{
		LinkedList<Integer> temp = new LinkedList<Integer>();
		LinkedList <Integer> q = new LinkedList<Integer>();
		int [] inDeg = new int [this.getVertNum()];
		for(int i = 0; i < this.getVertNum(); i++)
		{
			inDeg[i] = this.outDegree(i);
			if(inDeg[i] == 0)
			{
				q.add(i);
			}
		}
		
		while(q.size() > 0)
		{
			int u = q.remove();
			temp.add(u);
			for(int i = 0; i < inDeg.length; i++)
			{
				if(this.adjacent(u, i))
				{
					inDeg[i]--;
				}
				if(inDeg[i] == 0)
				{
					q.add(i);
				}
			}
			
		}
		return temp;
	}
	
	public LinkedList<Integer> topologicalOrderByDFS()
	{
		DFS topo = new DFS(this.getList());
		return topo.topoSort();
	}
	
	
	
	
	
	
	
	
	public static DirectedGraph readGraph(String fileName) throws Exception
	{
		BufferedReader in = null;
		DirectedGraph temp = null;
		
		try
		{
			in = new BufferedReader(new FileReader(fileName));
			
			String line = "";
			line = in.readLine();
			if(!line.equals(null))
			{
				temp = new DirectedGraph(Integer.parseInt(line));
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
				
				temp.getList().addVert(true, p1, p2);
				
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
