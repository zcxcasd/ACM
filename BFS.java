class BFS
{
	int dist[N];
	int mark[N];

	void search()
	{
		ArrayList queue = new ArrayList();
		dist[0] = 0;
		mark[0] = 1;
		while( !queue.empty())
		{
			int v = queue.pop();
			for(int i=0;i<AL[v].size();i++)
			{
				if(mark[AL[v][i]] == 0 )
				{
					mark[AL[v][i]] =1 ;
					queue.push(AL[v][i]);
					dist[AL[v][i]] = dist[v] + 1;
				}
			}
		}
}
