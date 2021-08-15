package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Jun. 5, 2021
 * https://dmoj.ca/problem/ucc21p5
 * Game Theory DP
 */

public class UCC23p5woodcuttingGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int [][][][]dp = new int [3][301][3][301];

	public static void main(String[] args) throws IOException {
		int h1, h2, w1, w2;
		
	}
//	public static int fun (int h1, int w1, int h2, int w2) {
//		if (dp[h1][w1][h2][w2] !=1) return dp[h1][w1][h2][w2]=0;
//		if (h1==1 && w1==1 && h2==1 && w2==1 ) return dp[h1][w1][h2][w2]=0;
//		int ret =0;
//		
//		//for (int i=1;i<h1;i++) ret |=((!fun(1,w1,h1-i,w1)) | (!fun (i,w1,h2,w2)) );
//		
//	}

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
