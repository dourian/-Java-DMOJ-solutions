package olympiads;

import java.io.*;
import java.util.*;
/*
 * Dorian Chen
 * Feb. 19, 2021
 * https://dmoj.ca/problem/ccc05s2
 * Simple Math
 */


public class ccc05s2MouseMove {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int c=readInt();
		int r =readInt();
		int a=0,b =0,x=0,y=0;
		x=readInt();
		y=readInt();
		while(x!=0 || y!=0) {
			a+=x;
			b+=y;
			if (a>c) a=c;
			if (a<0) a=0;
			if (b>r) b=r;
			if (b<0) b=0;
			System.out.println(a+" "+b);
			x=readInt();
			y=readInt();
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
