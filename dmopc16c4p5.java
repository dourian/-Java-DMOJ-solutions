package olympiads;

import java.io.*;

import java.util.*;

public class dmopc16c4p5 {

	public static class Pair implements Comparable<Pair> {
		int first;
		int second;

		public Pair (int first, int second) {
			this.first = first;
			this.second = second;
		}


		public int compareTo(Pair p) {
			return first - p.first;
		}
	}

	static ArrayList<Pair>[] adj;
	static PriorityQueue<Pair> pq;
	static int big = 10000000;
	static int [][] stp;
	static int [] dist;
	static boolean check[];
	static int n=0;
	static int m=0;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		n = readInt(); m =readInt();

		dist = new int [n+1]; check=new boolean[n+1]; adj = new ArrayList [n+1]; pq = new PriorityQueue<Pair>();
		for (int i=0;i<n+1;i++) adj[i]=new ArrayList<Pair> ();
		for (int i = 0 ;i<m;i++) {
			int a,b,c;

			a=readInt();b=readInt();c=readInt();

			adj[a].add(new Pair(c,b));
			adj[b].add(new Pair(c,a));
		}
		dfs();

		System.out.println(0);
		for (int i=2;i<=n;i++) {
			System.out.println(dist[i]);
		}
	}

	public static void dfs () {
		for (int i=0;i<n+1;i++) {
			dist[i]=Integer.MIN_VALUE;
			check[i]=false;
		}
		dist[1]=Integer.MAX_VALUE;
		pq.add(new Pair(0,1));
		while(!pq.isEmpty()) {
			Pair cur;
			cur = pq.poll();
			for (Pair q:adj[cur.second]) {
				if (dist[q.second]<Math.min(dist[q.second], q.first)) {
					dist[q.second]=Math.min(dist[q.second], q.first);
					pq.add(new Pair (dist[q.second], q.second));
				}
				//dist[q.second]=Math.max(dist[q.second], Math.min(dist[q.second], q.first));
			}
		}
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
