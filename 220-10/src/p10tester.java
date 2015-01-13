import java.util.Random;


public class p10tester
{

	public static void main(String[] args)
	{
		/*
		SeperateChainingHashMap tes0t = new SeperateChainingHashMap(17);
		
		test.put("hello", "cool, it works");
		
		System.out.println(test.isEmpty());
		
		System.out.println(test.getValue(5));
		
		test.put(1, 2);
		test.put(1, 5);
		
		System.out.print(test.getValue(1));
		*/
		
		
		Random gen = new Random();
		SeperateChainingHashMap test = new SeperateChainingHashMap(10007);
		
		//easily control puts
		int pow = 6;
		int n  = (int) Math.pow(10, pow);
		
		for(int i = 0; i < n; i++)
		{
			int bSize = test.size();
			test.put(gen.nextInt(), gen.nextInt());
			//check size on put to avoid double keys
			if(test.size() != (bSize + 1))
			{
				i--;
			}
		}
		
		System.out.println("SL: " + test.shortLength());
		System.out.println("LL: " + test.longLength());
		System.out.println("AL: " + test.avgLength());
		
		/*
		test.resize();
		
		System.out.println("SL: " + test.shortLength());
		System.out.println("LL: " + test.longLength());
		System.out.println("AL: " + test.avgLength());
		*/
	}

}
