package olympiads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc09s4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int n= readInt(), t = readInt(), adj[][] = new int[n+1][n+1];
		for(int i=1; i<=n; i++) Arrays.fill(adj[i], (int)1e9);
		for(int i=1; i<=t; i++) {
			int x = readInt(), y = readInt(), cost = readInt();
			adj[x][y] = adj[y][x] = cost;
		}
		int k = readInt(), shop[] = new int[k], pen[] = new int[k];
		for(int i=0; i<k; i++) {
			shop[i] = readInt(); pen[i] = readInt();
		}
		int dest = readInt(), dis[] = new int[n+1]; boolean vis[] = new boolean[n+1];
		Arrays.fill(dis, (int)1e9); dis[dest] = 0;
		for(int i=1; i<=n; i++) {
			int min = (int)1e9, u = -1;
			for(int j=1; j<=n; j++)
				if(!vis[j] && dis[j] < min) { min = dis[j]; u = j; }
			if(u == -1) break;
			vis[u] = true;
			for(int j=1; j<=n; j++)
				if(!vis[j] && dis[j] > dis[u] + adj[u][j]) dis[j] = dis[u] + adj[u][j];
		}
		int ans = (int)1e9;
		for(int i=0; i<k; i++)
			ans = Math.min(ans, dis[shop[i]] + pen[i]);
		System.out.println(ans);
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
