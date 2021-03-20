package olympiads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bobsvideogamefloyd {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), t=readInt();
		
		int [][]adj = new int [n+1][n+1];
		for (int i=1;i<=n;i++) {
			Arrays.fill(adj[i], (int) 1e9);
		}
		for (int i=1;i<=m;i++) {
			int u =readInt(), v=readInt(), w=readInt();
			adj[u][v]=w;
		}
		for (int k=1;k<=n;k++) {
			for (int s=1;s<=n;s++) {
				for (int j=1;j<=n;j++) {
					adj[s][j] =Math.min(adj[s][j], Math.max(adj[s][k], adj[k][j]));
				}
			}
		}
		for (int i=1;i<=t;i++) {
			int u=readInt(), v=readInt();
			System.out.println(adj[u][v]==1e9? -1:adj[u][v]);
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
