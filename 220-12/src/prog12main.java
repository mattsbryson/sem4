import java.util.LinkedList;


public class prog12main
{

	public static void main(String[] args) throws Exception
	{
		
		Graph testGraph = null;
		boolean windows = true;
		String filePath = "";
		String filePath2 = "";
		String filePath3 = "";
		String filePath4 = "";
		
		if(windows)
		{
			filePath = "C:/users/matt/Google Drive/Code/Sem4/220-12/input.txt";
			filePath2 = "C:/users/matt/Google Drive/Code/Sem4/220-12/input2.txt";
			filePath3 = "C:/users/matt/Google Drive/Code/Sem4/220-12/input3.txt";
			filePath4 = "C:/users/matt/Google Drive/Code/Sem4/220-12/input4.txt";
		}
		else
		{
			filePath = "/Users/Matt/Google Drive/Code/Sem4/220-11/input.txt";
			filePath2 = "/Users/Matt/Google Drive/Code/Sem4/220-11/input2.txt";
		}
		
		for(int z = 0; z < 4; z++)
		{
			
			if(z == 0)
			{
				testGraph = UndirectedGraph.readGraph(filePath);
			}
			else if(z == 1)
			{
				testGraph = DirectedGraph.readGraph(filePath2);
			}
			else if(z == 2)
			{
				testGraph = UndirectedGraph.readGraph(filePath3);
			}
			else
			{
				testGraph = DirectedGraph.readGraph(filePath4);
			}
				
			
			LinkedList <Integer> path = testGraph.path(0, 5);
			
			for(int i : path)
			{
				System.out.print(i + " ");
			}
			System.out.print("\n");
						
			LinkedList <Integer> shortest = testGraph.shortestPath(0, 5);
			for(int i : shortest)
			{
				System.out.print(i + " ");
			}
			System.out.print("\n");
			
			
		}
		
		
	}

}
