package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * May 15, 2021
 * https://dmoj.ca/problem/oly18novp1
 * Task Scheduling - Sort By Finish Time
 */

public class Segment {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		PriorityQueue <Pair> q = new PriorityQueue();

		for (int i=0;i<n;i++) {
			int s = readInt(), f = readInt();
			q.add(new Pair(s,f));
		}
		int lst=0;
		int ans=0;
		for (int i =0;i<n;i++) {
			Pair cur = q.poll();
			if (lst <= cur.s) {
				ans++; lst = cur.f;
			}
		}
		System.out.println(ans);
	}

	public static class Pair implements Comparable<Pair> {
		int s;
		int f;

		public Pair (int first, int second) {
			this.s = first;
			this.f = second;
		}


		public int compareTo(Pair p) {
			return f - p.f;
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
