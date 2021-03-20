package olympiads;

/*
 * Dorian Chen
 * Feb 13 2021
 * https://dmoj.ca/problem/cco14p1
 * DP
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cco14p1troyangles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(),dp[][] = new int [n+2][n+2];
		char g[][] = new char[n+1][n+1];
		for (int i=1;i<=n;i++)
			g[i]=("."+readLine()+".").toCharArray();
		int ans=0;
		for (int i=n;i>=1;i--) {
			for (int j=1;j<=n;j++) {
				if(g[i][j]!='#') continue;
				dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i+1][j-1], dp[i+1][j+1]))+1;
				ans+=dp[i][j];
			}
		}
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
