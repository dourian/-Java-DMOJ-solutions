package olympiads;

import java.io.*;
import java.util.*;

/*
 * Dorian Chen
 * Mar. 27, 2021
 * https://dmoj.ca/problem/oly21practice27
 * Binary Search + PSA + diff array
 */

public class dansBusiness {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		int [] p = new int[N+1], d = new int [N+1];
		
		for (int i=1;i<=N;i++) p[i]=readInt();
		for (int i=1;i<=M;i++) d[i]=readInt();
		
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
