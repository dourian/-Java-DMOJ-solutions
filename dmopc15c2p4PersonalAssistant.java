package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * May 15, 2021
 * https://dmoj.ca/problem/dmopc15c2p4
 * Task Scheduling With Weights - DP
 */

public class dmopc15c2p4PersonalAssistant {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		Pair [] q = new Pair [n+1];
		q[0]=new Pair (0,0,0);
		long [] dp = new long [n+1];
		for (int i=1; i<=n;i++) {
			long a, b, c;
			a=readLong();
			b = readLong();
			c= readLong();
			q[i]=(new Pair (a,a+b,c));
		}
		Arrays.sort(q);
		for (int i=1;i<=n;i++) {			
			int lo=0;
			int hi=n;
			int p=0;
			while (lo<=hi) {
				int mid=(hi + lo)/2;
				if (q[mid].f <=q[i].s) {p = mid; lo = mid+1;}
				else { hi = mid-1;}
			}
			dp[i] = Math.max(dp[i-1], q[i].h + dp[p]);
		}
		System.out.println(dp[n]);
	}
	static class Pair implements Comparable<Pair> {
		long s;
		long f;
		long h;

		public Pair(long first, long second, long third) {
			this.s = first;
			this.f = second;
			this.h = third;
		}

		public int compareTo(Pair p) {
			return Long.compare(f, p.f);
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
