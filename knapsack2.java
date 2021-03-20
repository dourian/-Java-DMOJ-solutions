package olympiads;

/*
 * Dorian Chen
 * Feb 7 2021
 * https://dmoj.ca/problem/dpe
 * DP
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class knapsack2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), W = readInt(), maxV = (int) (1e5+1);
		
		long dp[] = new long [maxV]; 
		Arrays.fill(dp, (long)(2e9));
		dp[0]=0;
		for (int i=0;i<N;i++) {
			int w=readInt(), val=readInt();
			for (int j=maxV-1;j>=val;j--) {
				dp[j]=Math.min(dp[j], dp[j-val]+w);
			}
		}
		
		for (int i=maxV-1;i>=0;i--) {
			if (dp[i]<=W) {System.out.println(i); return;}
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
