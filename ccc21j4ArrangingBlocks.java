package olympiads;
import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Feb. 20, 2021
 * https://dmoj.ca/problem/ccc21j4
 * Sorting + Mutually exclusive / inclusive
 */

public class ccc21j4ArrangingBlocks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String s =readLine();
		char [] shelf = new char [s.length()];
		int l=0;
		int m=0;
		int notlinl=0;
		int notminm=0;
		int minl=0;
		int linm=0;
		
		for (int i=0;i<s.length();i++) {
			char x = s.charAt(i);
			if (x=='L') l++;
			else if (x=='M') m++;
			shelf[i]=x;
		}
		for (int i=0;i<l;i++) {
			if (shelf[i]=='M') {
				minl++;
				notlinl++;
			}
			else if (shelf[i]!='L') {
				notlinl++;
			}
		}
		for (int i=l;i<m+l;i++) {
			if (shelf[i]=='L') {linm++; notminm++;}
			else if (shelf[i]!='M') notminm++;
		}

		System.out.println(notlinl+notminm-Math.min(linm,minl));
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
