public class P100
{
	public int[] mem;

	public static void main(String args[])
	{
		P100 p = new P100();
		p.mem = new int[200];
		p.run(,22);
	}

	public void run(int n, int m)
	{
		int res=0;
		for(int i=n;i<=m;i++)
		{
			int c = cycle(i,0);
			if( c>res)
				res = c;
		}
		System.out.println(res);
	}
	public int cycle(int n, int count)
	{
		//System.out.println(n);
		if(n==1)
		{
			count++;
			if(n<200)
				mem[n] = count;
			return count;
		}
		else if(n%2 == 1)
		{
			if(n<200)
				return mem[n]+count;
			else
			{
				n = 3*n+1;
				return cycle(n,++count);
			}
		}
		else
		{
			if(n<200)
				return mem[n]+count;
			else
			{
				n = n/2;
				return cycle(n,++count);
			}
		}
	}
}
