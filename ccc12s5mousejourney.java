package olympiads;

/*
 * Dorian Chen
 * Feb 13 2021
 * https://dmoj.ca/problem/ccc12s5
 * DP + Graph Theory
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc12s5mousejourney {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt(), n=readInt();
		int [][] dp = new int [r+1][c+1];
		for (int i=0;i<=r;i++) {
			Arrays.fill(dp[i], 0);
		}
		dp[1][1]=1;
		for (int i=0;i<n;i++) {
			int ro = readInt(), col = readInt();
			dp[ro][col]=-1;
		}
		for (int i=1;i<=r;i++) {
			for (int j=1;j<=c;j++) {
				if (dp[i][j]!=-1) {
					if (j-1>=1 && dp[i][j-1]>-1) {
						dp[i][j]+=dp[i][j-1];
					}
					if (i-1>=1 && dp[i-1][j]>-1) {
						dp[i][j]+=dp[i-1][j];
					}
				}
			}
		}
//		for (int i=0;i<=r;i++) {
//			for (int j=0;j<=c;j++) {
//				System.out.printf("%2d",dp[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(dp[r][c]);
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
