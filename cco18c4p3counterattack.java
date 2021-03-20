package olympiads;

import java.util.*;

import java.io.*;

public class cco18c4p3counterattack {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static ArrayList <edge> []adj;
	static ArrayList <edge> []adj2;
	static PriorityQueue<edge> pq = new PriorityQueue<edge> ();
	static int [] dst;
	static int [] dst2;
	static int n;
	static int m;
	static int big = (int) 1e9;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		adj = new ArrayList [n+1];
		adj2 = new ArrayList [n+1];
		dst = new int [n+1];
		dst2 = new int [n+1];
		int [] es = new int [m+1];
		
		for (int i=0;i<=n;i++) {
			adj[i] = new ArrayList ();
			adj2[i] = new ArrayList ();
		}
		for (int i=0;i<m;i++) {
			int a,b,c;
			a=readInt(); b =readInt(); c= readInt();
			adj[a].add(new edge (b,c));
			adj2[b].add(new edge (a,c));
		}
		djs(adj,1,0);
		djs(adj2,n,1);
		int min = dst[n];
		int second = Integer.MAX_VALUE;
		for (int i=0;i<n+1;i++) {
			int s = i;
			for (int e=0;e<adj[s].size();e++) {
				edge ed = adj[s].get(e);
				int end = ed.v;
				int l = ed.w;
				int nl = dst[s]+l+dst2[end];
				if (nl>min && nl<second) {
					second=nl;
				}
			}
		}
		if (second>=1e9) System.out.println("-1");
		else System.out.println(second);
	}
	public static void djs (ArrayList <edge> []adj,int start, int dstnum) {
		int []dstn = new int [n+1];
		for (int i =1;i<=n;i++) dstn[i]=big;
		dstn[start]=0;
		pq.add(new edge (start,0));
		while(!pq.isEmpty()) {
			edge cur = pq.poll();
			int u = cur.v;
			for (edge e:adj[u]) {
				int node = e.v;
				int w = e.w;
				if (dstn[node]>dstn[u]+w) {
					dstn[node]=dstn[u]+w;
					pq.add(new edge(node,dstn[node]));
				}
			}
		}
		if (dstnum==0) {
			dst=dstn;
		}
		else {
			dst2=dstn;
		}
	}
	static class edge implements Comparable <edge>{
		int v,w;
		edge(int v0,int w0) {v=v0;w=w0;}
		public int compareTo (edge x) { return Integer.compare(w, x.w);}
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
