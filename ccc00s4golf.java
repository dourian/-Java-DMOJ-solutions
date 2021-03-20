package olympiads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * Dorian Chen
 * Feb 7 2021
 * https://dmoj.ca/problem/ccc00s4
 * DP
 */

public class ccc00s4golf {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int d = readInt();
		int n = readInt();
		int[] clubs = new int [n+1];
		int[] dp = new int [d+1];
		Arrays.fill(dp, 0);
		for (int i=1;i<=n;i++) {
			int x = readInt();
			clubs[i]=x;
		}
		for (int i=1;i<=d;i++) {
			int min = Integer.MAX_VALUE;
			for (int j=1;j<=n;j++) {
				if (i-clubs[j]>=0) {
					if (dp[i-clubs[j]]<min) {
						min = dp[i-clubs[j]];
					}
				}
			}
			if (min!=Integer.MAX_VALUE) {
				dp[i]=min+1;
			}
			else {
				dp[i]=Integer.MAX_VALUE;
			}
		}
		if (dp[d]!=Integer.MAX_VALUE) {
			System.out.println("Roberta wins in "+dp[d]+" strokes.");
		}
		else {
			System.out.println("Roberta acknowledges defeat.");
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
