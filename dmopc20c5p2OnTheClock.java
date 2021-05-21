package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * May 15, 2021
 * https://dmoj.ca/problem/dmopc20c5p2
 * "Simple" Math
 */

public class dmopc20c5p2OnTheClock {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long N = readLong(), M = readLong();
		
		System.out.println(N + M - gcd(N,M));
		
		for (int i=1;i<=N;i++) {
			
			long lo = (i-1)* M / N+1, hi = (i*M + N-1)/N;
			
			for (long j=lo;j<=hi;j++) {
				
				System.out.println(i + " " + j);
				
			}
		}
	}
	static long gcd (long M , long N) {
		return N==0? M: gcd(N, M%N);
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
