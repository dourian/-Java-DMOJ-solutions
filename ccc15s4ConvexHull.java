package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * May 8, 2021
 * https://dmoj.ca/problem/ccc15s4
 * DP + Graph Theory?
 */

public class ccc15s4ConvexHull {

	public static class Pair implements Comparable<Pair> { //ty arthur
		int time;
		int hull;
		int node;

		public Pair (int first, int second, int third) {
			this.time = first;
			this.hull = second;
			this.node = third;
		}

		public int compareTo(Pair p) {
			return time - p.time;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int K =  readInt(), N = readInt(), M = readInt();
		int [][] dp = new int [N+1][K+1];

		for (int i=0;i<=N;i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

		ArrayList <Pair> [] adj = new ArrayList [N+1];
		for (int i=1;i<=N;i++) adj[i]=new ArrayList<Pair>();
		for (int i=0;i<M;i++) {
			int a = readInt(), b = readInt(), t = readInt(), h = readInt();
			adj[a].add(new Pair (t,h,b));
			adj[b].add(new Pair (t,h,a));
		}
		int s = readInt(), e = readInt();

		//djs

		dp[s][0]=0;

		PriorityQueue <Pair> pq = new PriorityQueue <Pair> ();
		pq.add(new Pair(0,0,s));

		Pair cur;
		while(pq.isEmpty()==false) {
			cur= pq.poll();
			int t = cur.time, h = cur.hull, n = cur.node;
			if (t>dp[n][h]) continue;
			for (Pair adjn: adj[n]) {
				int time = adjn.time, hull = adjn.hull, node = adjn.node;
				if (h+hull>=K) continue;
				if (dp[node][h+hull]>t+time) {
					dp[node][h+hull]=t+time;
					pq.add(new Pair (dp[node][h+hull],h+hull,node));
				}
				
			}
		}
		int min=Integer.MAX_VALUE;
		
//		for (int i=1;i<=N;i++) {
//			for (int j=0;j<K;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for (int i=0;i<K;i++) {
			if (dp[e][i]<min) {
				min = dp[e][i];
			}
		}
		if (min!=Integer.MAX_VALUE) {
			System.out.println(min);
		}
		else {
			System.out.println("-1");
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
