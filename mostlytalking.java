package olympiads;

import java.util.*;

import java.io.*;

public class mostlytalking {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static ArrayList<edge> [] adj;
	static ArrayList<edge> [] adj2;
	static int dis[];
	static int dis2[];
	static int cindy[];
	static boolean vst[];
	static boolean vst2[];
	static int n;
	static int m;
	static int big = 500005;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		adj = new ArrayList [n+1];
		adj2 = new ArrayList [n+1];
		vst = new boolean [n+1];
		vst2= new boolean [n+1];
		for (int i=0;i<=n;i++) {
			adj[i] = new ArrayList <edge>();
			adj2[i] = new ArrayList <edge>();
		}
		dis = new int [n+1];
		dis2 = new int [n+1];

		for (int i = 0 ; i<m ;i++) {
			int a,b,c;
			a=readInt();
			b=readInt();
			c=readInt();
			adj[a].add(new edge(b,c));
			adj2[b].add(new edge(a,c));
		}
		
		//first djs
		djs();
		//reverse djs
		djsr();
		
		int k = readInt();
		int min = dis[n];
		
		for (int i=1;i<=k;i++) {
			int a,b,c;
			a=readInt();
			b=readInt();
			c=readInt();
			if (min>dis[a]+c+dis2[b]) {
				min =dis[a]+c+dis2[b];
			}
		}

		if (min==big) {
			System.out.println("-1");
		}
		else {
			System.out.println(min);
		}
	}
	public static void djs () {
		PriorityQueue <edge> pq = new PriorityQueue <edge>();
		pq.add(new edge(1,0));
		Arrays.fill(dis, big);
		dis[1]=0;
		Arrays.fill(vst, false);
		while(!pq.isEmpty()) {
			edge e = pq.poll();
			int v = e.v;
			if (vst[v]==true) continue;
			vst[v]=true;
			for (edge f : adj[v]) {
				int u = f.v;
				int d = f.w;
				if (dis[u]>dis[v]+d) {
					dis[u] = dis[v]+d;
					pq.add(new edge(u,dis[u]));
				}
			}
		}
	}

	public static void djsr () {
		PriorityQueue <edge> pq = new PriorityQueue <edge>();
		pq.add(new edge(n,0));
		Arrays.fill(dis2, big);
		dis2[n]=0;
		Arrays.fill(vst2, false);
		while(!pq.isEmpty()) {
			edge e = pq.poll();
			int v = e.v;
			int w = e.w;
			if (vst2[v]==true) continue;
			vst2[v]=true;
			for (edge f : adj2[v]) {
				int u = f.v;
				int d = f.w;
				if (dis2[u]>dis2[v]+d) {
					dis2[u] = dis2[v]+d;
					pq.add(new edge(u,dis2[u]));
				}
			}
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
