package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Jun. 5, 2021
 * https://dmoj.ca/problem/graph2p1
 * dfs
 */

public class connectedComponents {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int n;
	static boolean adj[][], vis[];
	
	public static void main(String[] args) throws IOException {
		n = readInt();
		adj = new boolean [n][n];
		vis  = new boolean [n];
		for (int i=0;i<n;i++)
			for (int j=0;j<n;j++)
				adj[i][j] = readInt()  ==1;
		
		for (int i=0;i<n;i++) {
			if (vis[i])continue;
			List<Integer> list = new ArrayList();
			dfs(i,list);
			Collections.sort(list);
			for (int x : list) System.out.print( (x+1) + " ");
			System.out.println();
			
		}
		
	}
	public static void dfs(int v, List<Integer> list) {
		vis[v] = true; list.add(v);
		for (int i=0;i<n;i++)
			if (adj[v][i] && !vis[i]) dfs(i,list);
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
