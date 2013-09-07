class BellmanFord
{
	int dist[MAX];
	ArrayList[] AL = new ArrayList[N];
		
	void BF()
	{
		dist[0] = 0;
		for(int v=1;v<N;v++)
			dist[v] = INF;
		for(int k=0;k<N-1;k++)
		{
			for(int v=0;v<N;v++)
			{
				for(int i=0;i<AL[v].size();i++)
				{
					int j = AL[v].get(i);
					dist[j] = min(dist[k], dist[v], L[v][j]);
				}
			}
		}
	}

	boolean neg()
	{
		dist[0] = 0;
		for(int v=1;v<N;v++)
			dist[v] = INF;
		for(int k=0;k<N-1;k++)
		{
			for(int v=0;v<N;v++)
			{
				for(int i=0;i<AL[v].size();i++)
				{
					int j = AL[v].get(i);
					dist[j] = min(dist[k], dist[v], L[v][j]);
				}
			}
		}
		for(int v=0;v<N;v++)
		{
			for(int i=0;i<AL[v].size();i++)
			{
				int j = AL[v].get(i);
				if(dist[v]+L[v][j] < dist[j]) return false;
			}
		}
		return true;
	}
}
