package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 24, 2021
 * https://dmoj.ca/problem/ioi94p1
 * DP
 */

public class IOI94p1TheTriangle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int inputs = 0;
		
		int [][]dp = new int [n+1][n+1];
		for (int i=0;i<=n;i++)Arrays.fill(dp[i], -1);
		for (int i=0;i<n;i++) {
			inputs++;
			for (int k=0;k<inputs;k++) {
				dp[i][k]=readInt();
			}
		}
		inputs=n;
		for (int i=n-2;i>=0;i--) {
			inputs--;
			for (int k=0;k<inputs;k++) {
				if (dp[i][k]!=-1) {
					dp[i][k]+=Math.max(dp[i+1][k],dp[i+1][k+1]);
				}
			}
		}
//		for (int i=0;i<=n;i++) {
//			for (int j=0;j<=n;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[0][0]);
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
