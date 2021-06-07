package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Jun. 5, 2021
 * https://dmoj.ca/problem/acsl1p4
 * Tarjan
 */

public class rank {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int n,m,ans, dfn[], low[], idx; static List <Integer> adj[];
	static Stack<Integer> stk;
	static boolean in[];
	
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt(); dfn = new int [n+1]; low = new int[n+1];
		stk  =new Stack();
		in  = new boolean [n+1];
		adj = new ArrayList [n+1];
		for (int i=1;i<=n;i++) adj[i] = new ArrayList();
		for (int i=1;i<=m;i++) {
			int a = readInt(), b = readInt(), sa = readInt(), sb = readInt();
			if (sa >sb) adj[a].add(b);
			else adj[b].add(a);
		}
		for (int i=1;i<=n;i++) {
			if (dfn[i] ==0)tarjan(i);
		}
		System.out.println(ans);
	}
	public static void tarjan (int u) {
		dfn[u] = low[u] = ++idx; stk.push(u); in[u]=true;
		for (int v : adj[u]) {
			if (dfn[v]==0) {
				tarjan(v); low[u] = Math.min(low[u], low[v]);
			}
			else if (in[v]) {
				low[u] = Math.min(low[u], dfn[v]);
			}
		}
		if (dfn[u] == low[u]) {
			int sz = 0, x=0;
			do {
				x=stk.pop(); in[x]=false; sz++;
			} while (x!=u);
			if (sz>2)ans+=sz;
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
