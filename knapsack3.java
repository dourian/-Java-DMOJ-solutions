package olympiads;

/*
 * Dorian Chen
 * Feb 13 2021
 * https://dmoj.ca/problem/knapsack
 * DP
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class knapsack3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m=readInt(), maxW = 5000;
		long dp []= new long[maxW+1];
		for (int i=1;i<=n;i++) {
			int num = readInt(), cost =readInt(), val = readInt();
			
			//binary packaging
			for (int k=1;k<=num;k=k*2) {
				long w=(long)k*cost, v=(long)k*val;
				for (int j=maxW;j>=w;j--) {
					dp[j]=Math.max(dp[j], dp[(int)(j-w)]+v);
				}
				num-=k;
			}
			if(num>0) {
				long w=(long)num*cost, v=(long)num*val;
				for (int j=maxW;j>=w;j--) {
					dp[j]=Math.max(dp[j], dp[(int)(j-w)]+v);
				}
			}
		}
		long ans = Long.MIN_VALUE;
		for (int i=1;i<=m;i++) {
			int cap=readInt(), fuel = readInt();
			ans = Math.max(ans, dp[cap]-fuel);
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
