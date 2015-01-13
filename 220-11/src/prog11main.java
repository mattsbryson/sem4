import java.util.LinkedList;


public class prog11main
{

	public static void main(String[] args) throws Exception
	{
		
		graph testGraph = null;
		boolean windows = true;
		String filePath = "";
		String filePath2 = "";
		
		if(windows)
		{
			filePath = "C:/users/matt/Google Drive/Code/Sem4/220-11/input.txt";
			filePath2 = "C:/users/matt/Google Drive/Code/Sem4/220-11/input2.txt";
		}
		else
		{
			filePath = "/Users/Matt/Google Drive/Code/Sem4/220-11/input.txt";
			filePath2 = "/Users/Matt/Google Drive/Code/Sem4/220-11/input2.txt";
		}
		
		try
		{
			 testGraph = graph.readGraph(filePath);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		for(int z = 0; z < 2; z++)
		{
			if(z > 0)
			{
				testGraph = graph.readGraph(filePath2);
			}
			System.out.println("Verticies: " + testGraph.getVertNum());
			System.out.println("Edges: " + testGraph.getEdgeNum());
			System.out.println("0 & 9 Adjacent: " + testGraph.adjacent(0, 9));
			System.out.println("4 & 7 Adjacent: " + testGraph.adjacent(4, 7));
			System.out.println("0 & 9 Connected: " + testGraph.isConnected(0, 9));
			System.out.println("4 & 7 Connected: " + testGraph.isConnected(4, 7));
			
			LinkedList <Integer> path = testGraph.path(0, 9);
			
			for(int i : path)
			{
				System.out.print(i + " ");
			}
			System.out.print("\n");
						
			LinkedList <Integer> shortest = testGraph.shortestPath(0, 9);
			for(int i : shortest)
			{
				System.out.print(i + " ");
			}
			System.out.print("\n");
			
			LinkedList<LinkedList<Integer>> conComp = testGraph.getConnectedComponents();
			System.out.println("Connected Componets: ");
			for(LinkedList<Integer> l : conComp)
			{
				for(int i : l)
				{
					System.out.print(i + " ");
				}
				System.out.print("\n");
			}
		}
		
		
	}

}
