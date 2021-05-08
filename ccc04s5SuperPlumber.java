package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 24, 2021
 * https://dmoj.ca/problem/ccc04s5
 * DP D:
 */

public class ccc04s5SuperPlumber {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int r =readInt(), c = readInt();
		
		while (r!=0 && c!=0) {
			int [][] dp  = new int [r+1][c+1];
			
			
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
