package olympiads;

import java.util.*;
import java.io.*;
import java.math.*;

/*
 * Dorian Chen
 * May 1, 2021
 * https://dmoj.ca/problem/dmopc14c3p5
 * Bitmask
 */

public class dmopc14c3p5NotEnoughServers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		int [] cases = new int [M]; int fin=0; boolean ac=true;
		for (int i=0;i<N;i++) {
			char [] c = readLine().toCharArray(); ac = true;
			for (int j=0;j<M;j++) {
				cases[j]<<=1;
				if (c[j]=='X') {
					ac=false;
					cases[j] |=1;
				}
			}
			fin = fin<<1 | (ac? 0:1);
		}
		if (fin==0) {System.out.println("1\n1"); return;}
		int [] dp = new int [1<<N], prev = new int [1<<N], use = new int[1<<N];
		Arrays.fill(dp, (int)1e9);
		dp[0] = 0;
		for (int i=0; i<M;i++ ) {
			for (int omask=0;omask<(1<<N);omask++) {
				int nmask = omask | cases[i];
				if (dp[nmask]>dp[omask]+1) {
					dp[nmask]=dp[omask]+1;
					prev[nmask]=omask;
					use[nmask]=i+1;
				}
			}
		}
		
		
//		for (int i=0;i<dp.length;i++) {
//			System.out.print(dp[i]+" ");
//		}
		System.out.println(dp[fin]);
		for (int i=fin;i!=0;i=prev[i]) {
			System.out.print(use[i]+" ");
		}
		System.out.println();
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
