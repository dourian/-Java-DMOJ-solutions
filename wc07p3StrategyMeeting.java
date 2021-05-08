package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * May 8, 2021
 * https://dmoj.ca/problem/wc07p3
 * graph?
 */

public class wc07p3StrategyMeeting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int t = readInt(), n = readInt();
		int [][] map  = new int [n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				map[i][j]=readInt();
			}
		}
	}
	void dfs (int u, int v) {


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
