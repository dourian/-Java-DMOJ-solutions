package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Mar. 15, 2021
 * https://dmoj.ca/problem/coci07c4p4
 * DP
 */

public class coci07c4p4Muzicari {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = readInt(), N = readInt();
		
		boolean [] dp = new boolean [N+1];
		int [] id = new int [N+1];
		int [] m = new int[N+1];
		ArrayList <Integer> track = new ArrayList ();
		
		for (int i=1;i<=N;i++) {
			id[i]=readInt();
		}
		
		for (int i=0;i<N;i++) {
			for (int e=N;e>=0;e--) {
				if (dp[e]==true) {
					if (e+m[N]<N) {
						dp[e+m[N]]=true;
						id[e+m[N]]=N;
					}
				}
			}
		}
		if (dp[N]==true) {
			int x= N;
			while (x>0) {
				track.add(m[id[x]]);
				x-=m[id[x]];
			}
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
