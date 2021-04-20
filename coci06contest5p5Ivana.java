package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 10, 2021
 * https://dmoj.ca/problem/coci06c5p5
 * Circle DP
 */

public class coci06contest5p5Ivana {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n =readInt();
		int dp[][] = new int [2*n+1][2*n+1];
		for (int i=1;i<=n;i++) {
			dp[i+n][i+n]= dp[i][i] = readInt()%2;
		}
		for (int len =1;len<=n;len++) {
			for (int L=1;L+len<=2*n;L++) {
				int R = L+len;
				dp[L][R]= Math.max(dp[L][L]- dp[L+1][R], dp[R][R] - dp[L][R-1]);
			}
		}
		int ans = 0;
		for (int i=1;i<=n;i++)
			if (dp[i][i]-dp[i+1][i-1+n]>0 )ans++;
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
