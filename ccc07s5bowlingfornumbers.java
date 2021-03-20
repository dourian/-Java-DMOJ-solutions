package olympiads;

/*
 * Dorian Chen
 * Feb 13 2021
 * https://dmoj.ca/problem/ccc07s5
 * DP
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ccc07s5bowlingfornumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int z =0;z<t;z++) {
			int n=readInt(), k=readInt(), w =readInt();
			int pin [] = new int [n+1];
			int dp [][] = new int [k+1][n+1];
			for (int i=1;i<=n;i++) {
				int x = readInt();
				pin[i]=pin[i-1]+x;
			}

			for (int i=1;i<=k;i++) {
				for (int j=1;j<=n;j++) {
					if(j<=w) dp[i][j]=pin[j];
					else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-w]+pin[j]-pin[j-w]);
				}
			}
			System.out.println(dp[k][n]);
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
