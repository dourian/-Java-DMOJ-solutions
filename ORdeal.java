package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 24, 2021
 * https://dmoj.ca/problem/gfssoc3s1
 * Bitwise operation
 */

public class ORdeal {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long n = readLong();
		long plus=1;
		String ans="1";
		for (long i=1;i<n;i+=plus) {
			plus*=2;
			ans+="1";
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
