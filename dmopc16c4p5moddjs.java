package olympiads;

import java.util.*;
import java.io.*;

public class dmopc16c4p5moddjs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n=readInt(),m=readInt(); List <edge>adj[] = new ArrayList [n+1];
		for (int i=1;i<=n;i++) adj[i] = new ArrayList();
		for (int i=1;i<=m;i++) {
			int u =readInt(), v=readInt(), w=readInt();
			adj[u].add(new edge(v,w)); adj[v].add(new edge(u,w));
		}
		PriorityQueue<edge> q = new PriorityQueue();
		int dis[] = new int [n+1]; boolean vis[] =new boolean[n+1];
		dis[1] = (int) 1e9; q.add(new edge(1,dis[1]));
		while (!q.isEmpty()) {
			edge e=q.poll(); int u=e.v, d=e.w;
			if (vis[u]) continue;
			vis[u]=true;
			for (edge f: adj[u]) {
				int v=f.v, w=f.w;
				if (dis[v]<Math.min(dis[u], w)) {
					dis[v]=Math.min(dis[u], w);
					q.add(new edge (v,dis[v]));
				}
			}
		}
		dis[1]=0;
		for (int i=1;i<=n;i++) System.out.println(dis[i]);
	}
	static class edge implements Comparable <edge>{
		int v,w;
		edge(int v0,int w0) {v=v0;w=w0;}
		public int compareTo (edge x) { return -Integer.compare(w, x.w);}
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
