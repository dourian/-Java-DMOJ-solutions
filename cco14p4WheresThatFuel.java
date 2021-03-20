package olympiads;

/*
 * Dorian Chen
 * Feb 19 2021
 * https://dmoj.ca/problem/cco14p4
 * Greedy + DP
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cco14p4WheresThatFuel {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n =readInt(), s = readInt();
		int [] v = new int [n+1];
		for (int i=1;i<=n;i++) {
			int a=readInt(), b=readInt();
			if (i==s) {
				v[i]=a;
			}
			else {
				v[i]=a-b;
			}
		}
		
		int ini = v[s];
		int count=0;
		v[s]=0;
		Arrays.sort(v);
		for (int i=n;i>0;i--) {
			count=n-1;
			if(v[i]>=0) {
				ini+=v[i];
			}
			else {
				System.out.println(ini);
				System.out.println(n-i);
				return;
			}
		}
		System.out.println(ini);
		System.out.println(count);
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
