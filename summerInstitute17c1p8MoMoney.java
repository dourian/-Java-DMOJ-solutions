package olympiads;

import java.io.*;
import java.util.*;

/*
 * Dorian Chen
 * Mar. 5, 2021
 * https://dmoj.ca/problem/si17c1p8
 * Permutation
 */

public class summerInstitute17c1p8MoMoney {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt(); 
		int [] a = new int [n];
		int [] dp = new int [t+1];
		int [] dp2 = new int [t+1];
		for (int i=0;i<n;i++) {
			a[i]=readInt();
		}
		Arrays.fill(dp, 0);
		for (int i=0;i<n;i++) {
			for (int j=0;j<=t;j++) {
				if(dp[j]!=0) {
					if (j+a[i]<=t) {
						dp2[j+a[i]]=dp[j];
					}
				}
			}
			for (int j=0;j<=t;j++) {
				if(dp2[j]!=0) {
					dp[j]+=dp2[j];
				}
			}
			Arrays.fill(dp2, 0);
			if (a[i]<=t) dp[a[i]]++;
		}
		System.out.println(dp[t]);
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
