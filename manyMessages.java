package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * May 1, 2021
 * ECOO
 */

public class manyMessages {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int s = readInt(), in = readInt(), t = readInt();
		for (int i=0;i<3;i++) {
			s+=in;
			if (s>=t) {
				System.out.print(s);
				return;
			}
		}
		System.out.print("Who knows...");
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
