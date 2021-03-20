package olympiads;

import java.io.*;
import java.util.*;

public class ccc15s4 {
	public static class Pair implements Comparable<Pair> {
		int first;
		int second;
		int third;

		public Pair (int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}


		public int compareTo(Pair p) {
			return first - p.first;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int k= readInt(); int n = readInt(); int m=readInt();
		ArrayList <Pair>[] adj = new ArrayList [n+1];
		for (int i=0;i<adj.length;i++) adj[i]=new ArrayList <Pair>();
		boolean []vis=new boolean[n+1];
		int [][]dist=new int [n+1][k];
		
		for (int i=0;i<m;i++) {
			int a,b,t,h;
			a=readInt(); b=readInt(); t=readInt(); h=readInt();
			adj[a].add(new Pair(b,t,k));
		}
		int start=readInt(); int end=readInt();
		
		PriorityQueue <Pair> pq = new PriorityQueue<Pair> ();
		//pq.add(adj[start]);
		
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
