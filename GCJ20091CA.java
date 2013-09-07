import java.io.*;
import java.util.*;
import java.math.*;
class GCJ20091CA
{
	public static void main(String args[]) throws Exception
	{
		FileInputStream fis = new FileInputStream("input.txt");
		Scanner scan = new Scanner(fis);
		FileWriter fw = new FileWriter("output.txt");

		int T = scan.nextInt();
		scan.nextLine();
		for(int test =0; test< T; test++)
		{
			String in = scan.nextLine();
			//search how many distinct characters there are
			//correspond first digit as 1
			//then assign every number from 0 -> ...

			ArrayList dist = new ArrayList();
			for(int i=0;i<in.length();i++)
			{
				if(!dist.contains(in.charAt(i)))
					dist.add(in.charAt(i));
			}
			int numDist = dist.size();
			int base = numDist==1?2:numDist;
			int length = in.length();
			int intIn[] = new int[length];
			for(int i=0;i<length;i++)
				intIn[i] = -1;
			intIn[0] = 1;
			for(int i=0;i<length;i++)
			{
				if(in.charAt(i) == in.charAt(0))
					intIn[i] = 1;
			}
			int second = 0;
			for(int i=1;i<length;i++)
			{
				if(intIn[i] == -1)
				{
					second = i;	
					break;
				}
			}
			for(int i=second;i<length;i++)
			{
				if(intIn[i] == -1)
				{
					if(in.charAt(i) == in.charAt(second))
						intIn[i] = 0;
				}
			}
			int cur = 2;
			for(int i=2;i<length;i++)
			{
				if(intIn[i] == -1)
				{
					for(int j=i;j<length;j++)
					{
						if(in.charAt(i) == in.charAt(j))
							intIn[j] = cur;
					}
					cur++;
				}
			}
			//take intIn and be based
			long sum = 0;
			for(int i=0;i<length;i++)
			{
				long temp = intIn[i] * pow(base,length-i-1);
				sum += temp;
			}
			fw.write("Case #"+(test+1)+": "+sum+"\n");
		}
		fw.close();
	}
	public static long pow(int base, int pow)
	{
		if(pow == 1) return base;
		if(pow == 0) return 1;
		long res =  base * pow(base, pow-1);
		return res;
	}
}
