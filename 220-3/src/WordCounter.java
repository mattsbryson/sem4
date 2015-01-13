import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class WordCounter {

	public static void main(String[] args) throws IOException 
	{
		File input = new File("lib\\input.txt");
		HashMap WordCounts = WordHash(input);
		HashPrint(WordCounts);
		
		

		
	}
	
	public static HashMap WordHash(File input) throws IOException
	{
		//System.out.println(input.canRead());
		BufferedReader reader = new BufferedReader(new FileReader(input));
		HashMap words = new HashMap();
		

		String in;
		while((in = reader.readLine())!= null)
		{
			while(in.length() > 0)
			{
				String word;
				int wordEnd = in.indexOf(' ');
				if(wordEnd == -1)
				{
					word = in;
					in = "";					
				}
				else
				{
					word = in.substring(0, wordEnd);
					in = in.substring(wordEnd + 1);
				}
				word = word.toLowerCase();
				if(words.get(word) != null)
				{
					Integer count = (Integer) words.get(word);
					words.put(word, count + 1);
				}
				else
				{
					words.put(word, 1);
				}
				
			}
		}
		return words;
	}
	
	public static void HashPrint(HashMap words) throws IOException
	{
		File output = new File("lib\\output.txt");
		if(!output.exists())
		{
			output.createNewFile();
		}
		PrintWriter out = new PrintWriter(output);
		
		Set set = words.entrySet();
		Iterator i = set.iterator();
		
		while(i.hasNext())
		{
			Map.Entry<String, Integer> word = (Map.Entry<String, Integer>)i.next();
			out.println(word.getKey() + ": " + word.getValue());
		}
		out.close();
	}

}
