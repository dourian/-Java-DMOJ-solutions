package olympiads;

import java.io.*;
import java.util.*;

/*
 * Dorian Chen
 * Apr. 3, 2021
 * https://dmoj.ca/problem/dpl
 * Interval DP: target O(n^2)
 * 
 * Since they are playing optimally, you can think of it as them playing with the same DP table.
 * 
 * dp[L][R]: max points the first player can get from interval [L,R]
 * 
 * DP transition:
 * 		Case 1: take left endpoint
 * 		sum(L,R) - dp[L+1][R]
 * 		
 * 		Case 2: take right endpoint
 * 		sum(L,R) - dp[L][R-1]
 * 
 * 		| Make the other player get the least amount of points possible
 * 
 * 		dp[L][R] = max{ sum(L,R) - dp[L+1][R] , sum(L,R) - dp[L][R-1]}
 * 
 */

public class deque {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = readInt(); long psa [] = new long [N+1];
		long [][] dp = new long [N+1][N+1];
		
		for (int i=1;i<=N;i++) {
			int m =readInt();
			dp[i][i]=m;
			psa[i]=m + psa[i-1];
		}
		for (int i=1;i<=N;i++) {
			for (int L=1;L+i<=N;L++) {
				int R = L+i;
				dp[L][R] = psa[R]-psa[L-1] - Math.min(dp[L+1][R], dp[L][R-1]);
			}
		}
		System.out.println(dp[1][N]-(psa[N]-dp[1][N]));
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
