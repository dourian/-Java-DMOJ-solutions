package olympiads;
/*
 * Dorian Chen
 * Feb 7 2021
 * https://dmoj.ca/problem/dpa
 * DP
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class frog1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(); int [] dp = new int [n+1]; int [] heights = new int [n+1];
		for (int i=1;i<=n;i++) {
			int h = readInt();
			heights[i]=h;
		}
		dp[1]=0;
		dp[2]=Math.abs(heights[2]-heights[1]);
		if (n==2) {
			System.out.println(dp[2]);
			return;
		}
		else {
			for (int i =3;i<=n;i++) {
				dp[i]=Math.min(dp[i-2]+Math.abs(heights[i]-heights[i-2]), dp[i-1]+Math.abs(heights[i]-heights[i-1]));
			}
			System.out.println(dp[n]);
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
