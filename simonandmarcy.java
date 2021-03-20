package olympiads;

/*
 * Feb 7 2021
 * Knapsack DP
 * https://dmoj.ca/problem/valday15p2
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class simonandmarcy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int C=readInt(), M=readInt(); int dp [][] = new int  [C+1][M+1];
		for (int i=0;i<C;i++) {
			Arrays.fill(dp[i], 0);
		}
		for (int i=1;i<=C;i++) {
			int v =readInt();
			int c = readInt();
			for (int w =1;w<=M;w++) {
				if (c>w) dp[i][w]=dp[i-1][w];
				else {
					dp[i][w]=Math.max(v+dp[i-1][w-c], dp[i-1][w]);
				}
			}
		}
//		for (int i=0;i<=C;i++) {
//			for (int j=0;j<=M;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[C][M]);
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
