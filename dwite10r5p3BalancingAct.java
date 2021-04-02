package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Mar. 29, 2021
 * https://dmoj.ca/problem/dwite10c5p3
 * DP partitioning
 */

public class dwite10r5p3BalancingAct {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		for (int i=0;i<5;i++) {
			int n = readInt();
			int [] num = new int [n+1];
			int tot = 0;
			for (int j=0;j<n;j++) {
				int m=readInt();
				num[j+1]=m;
				tot+=m;
			}
			boolean [] dp = new boolean [tot+1];
			dp[0]=true;
			for (int e=1;e<=n;e++) {
				for (int j=tot;j>=0;j--) {
					if (dp[j]==true && j+num[e]<=tot) {
//						System.out.println(num[e]);
						dp[j+num[e]]=true;
					}
				}
			}
//			for (int j=1;j<=tot;j++) {
//				System.out.print(dp[j]);
//			}
//			System.out.println();
			int mind = Integer.MAX_VALUE;
			for (int e=1;e<=tot;e++) {
				if (dp[e]==true) {
					mind = Math.min(Math.abs(e-(tot-e)), mind);
				}
			}
			System.out.println(mind);
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
