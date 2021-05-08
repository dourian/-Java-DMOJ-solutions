package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 24, 2021
 * https://dmoj.ca/problem/dwite09c6p2
 * Brute force ?
 */

public class dwite09r6p2Roundtopoweroftwo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		for (int i=0;i<5;i++) {
			int n = readInt();
			int smal=1;
			int big;
			for (int k=1;k<n;k*=2) {
				smal=k;
			}
			big=smal*2;
			if (n-smal<big-n)System.out.println(smal);
			else System.out.println(big);
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
