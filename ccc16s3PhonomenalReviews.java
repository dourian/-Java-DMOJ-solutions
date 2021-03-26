package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Mar. 24, 2021
 * https://dmoj.ca/problem/ccc16s3
 * Graph Theory --> pruning + dfs
 */

public class ccc16s3PhonomenalReviews {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static TreeSet<Integer> [] adj;
	static TreeSet<Integer> pho;
	static int N;
	static int M;
	static int numPrune;
	static int dst=0;
	public static void main(String[] args) throws IOException {
		N = readInt();
		M = readInt();

		pho = new TreeSet<Integer>();
		adj = new TreeSet [N];
		for (int i=0;i<N;i++) adj[i]=new TreeSet<Integer>();

		for (int i=0;i<M;i++) {
			int x = readInt();
			pho.add(x);
		}
		for (int i=0;i<N-1;i++) {
			int a=readInt(), b = readInt();
			adj[a].add(b);
			adj[b].add(a);
		}

		prune();

		int numNode = N - numPrune;

		int a = furthestbfs(pho.first());
		int b = furthestbfs(a);

		System.out.println(numNode*2 - dst-1);

	}
	public static void prune () {
		Queue <Integer> q = new LinkedList ();
		for (int i=0;i<N;i++) {
			if (adj[i].size()==1 && !(pho.contains(i))) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int leaf = q.poll();
			int parent = (int) adj[leaf].first();
			adj[leaf].remove(Integer.valueOf(parent));
			adj[parent].remove(Integer.valueOf(leaf));
			numPrune++;
			if (adj[parent].size()==1 && !(pho.contains(parent))) {
				q.add(parent);
			}
		}
	}
	public static int furthestbfs (int x) {
		Queue <Integer> q = new LinkedList();
		boolean [] vis = new boolean [N];
		int last=0;
		q.add(x);
		vis[x]=true;
		int count=0;
		while (!q.isEmpty()) {
			int loop = q.size();
			count++;
			for (int j=0;j<loop;j++) {
				int cur = q.poll();
				for (int neighbour:adj[cur]) {
					System.out.println(neighbour);
					if (!vis[neighbour]) {
						q.add(neighbour);
						vis[neighbour]=true;
						last=neighbour;
					}
				}
			}
		}
		dst=count;
		return last;
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
