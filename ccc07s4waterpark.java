package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Jun. 6, 2021
 * https://dmoj.ca/problem/ccc07s4
 * DP + DFS
 */

public class ccc07s4waterpark {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Integer> [] adj = new ArrayList [n+1];
		int [] dp = new int [n+1];
		dp[n]=1;
		for (int i=1;i<=n;i++) adj[i] = new ArrayList();
		int a = readInt(), b = readInt();
		while (a!=0 && b!=0) {
			adj[b].add(a);
			a = readInt();
			b = readInt();
		} 
		
		if (adj[n].size()==0) {
			System.out.println(0);
			return;
		}
		
		for (int i=n;i>0;i--) {
			for (int x:adj[i]) {
				dp[x]+=dp[i];
			}
		}
		System.out.println(dp[1]);
//		for (int i=0;i<=n;i++) {
//			System.out.println(dp[i]+ " ");
//		}
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
