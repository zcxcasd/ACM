class DFS
{
	int mark[N];
	ArrayList[] AL = new ArrayList(N);
	
	void search(int node)
	{
		mark[node] = 1; // is visited
		for(int v=0; v<AL[node].size(); v++)
		{
			if(mark[AL[node].get(v)] == 0)
				search(AL[node].get(v));
		}
	}
	void search2(int node)
	{
		if(mark[node] == 1) return;
		mark[node] = 1; // is visited
		for(int v=0; v<AL[node].size(); v++)
		{
			search2(AL[node].get(v));
		}
	}

	int comp[N];
	int ncomp=0;
	void numComp(int node)
	{
		if(mark[node] == 1) return;
		mark[node] = 1; // is visited
		comp[node] = ncomp;
		for(int v=0; v<AL[node].size(); v++)
		{
			search2(AL[node].get(v));
		}
	}
	void countComp()
	{
		ncomp =0;
		for(int v=0;v<N;v++)
		{
			if(mark[v] ==0)
			{
				numComp(v);
				ncomp++;
			}
		}
	}

	int color[N];
	void bicolorable(int node, int c)
	{
		if(mark[node] == 1) return color[node] ==c;
		mark[node] = 1;
		color[node] =c;
		for(int v=0; v<AL[node].size(); v++)
		{
			if(!bicolorable(AL[node][v], 1-c))
				return false;
		}
		return true;
	}
}
