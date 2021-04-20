package olympiads;

/*
 * Dorian Chen
 * Apr. 3, 2021
 * https://dmoj.ca/problem/ccc16s4
 * Interval DP
 * 
 * Target: O(n^3)
 * 
 * dp[L][R]: is it possible to join all rice balls from L to R?
 * 
 * Dp transition:
 * 		operation 1: if dp[L][m] and dp[m+1][R] and sum(L,m) == sum(m+1,R) ⇒ dp[L][R] = true
 * 		operation 2:  if dp[L][p] and dp[q][R] and dp[p+1][q-1] and sum(L, p) == sum(q, R) ⇒ dp[L][R] = true
 * 
 */

import java.io.*;
import java.util.*;

public class ccc16s4CombiningRiceballs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n  = readInt(), psa[] = new int [n+1], ans=0; boolean dp[][] = new boolean [n+1][n+1];
		for (int i=1;i<=n;i++) {
			psa[i]=readInt(); ans = Math.max(ans, psa[i]);
			psa[i]+=psa[i-1];
			dp[i][i]=true;
		}
		for (int len=1;len<n;len++) {
			for (int L=1;L+len<=n;L++) {
				int R = L + len;
				for (int p=L, q=R; p<q;) {
					int sumL = psa[p]-psa[L-1], sumR = psa[R]-psa[q-1];
					if (dp[L][p] && dp[q][R] && p+1==q && sumL == sumR) { //operation 1: join two adjacent same size rice ball
						dp[L][R]=true;
					}
					if (dp[L][p] && dp[q][R] && dp[p+1][q-1] && sumL == sumR) {//operation 2: join 3 adj rice balls
						dp[L][R]=true;
					}
					if (dp[L][R]) ans = Math.max(ans,  psa[R]-psa[L-1]);
					if (sumL<sumR)p++;
					else q--;
				}
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
