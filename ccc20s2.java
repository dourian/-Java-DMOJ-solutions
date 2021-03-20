package olympiads;

import java.util.*;
import java.io.*;

public class ccc20s2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int m = readInt(), n=readInt(), a[][]=new int [m+1][n+1], maxVal=100001;
		List<Integer> adj[] = new ArrayList[maxVal];
		for (int i=0;i<adj.length;i++) adj[i]=new ArrayList();
		for (int i=1;i<=m;i++) {
			for (int j=1;j<=n;j++) {
				a[i][j] = readInt();
				adj[i*j].add(a[i][j]);
			}
		}
		boolean vis[] = new boolean[maxVal];
		Queue<Integer> q =new LinkedList();
		q.add(a[1][1]); vis[a[1][1]]=true;
		while(!q.isEmpty()) {
			int cur= q.poll();
			for (int nxt:adj[cur]) {
				if (!vis[nxt])
					q.add(nxt); vis[nxt]=true;
			}
		}
		System.out.println(vis[m*n]? "yes": "no");
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

