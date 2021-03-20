package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Mar. 6, 2021
 * https://dmoj.ca/problem/vmss7wc16c2p3 
 * LCS - all numbers are distinct -> turn lcs to lis
 */

public class vm7wc16p2GoldGGG {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(), maxV = (int)1e6, pos[] = new int [maxV+1];
		for (int i=1;i<=n;i++) pos[readInt()]=i;
		int m = readInt(); 
		List <Integer> lis = new ArrayList();
		for (int i=1;i<=m;i++) {
			int x = pos[readInt()];
			if (x==0) continue;
			if (lis.isEmpty() || lis.get(lis.size()-1)<x) lis.add(x);
			else {
				int p =Collections.binarySearch(lis, x);
				if (p<0) p =-p-1;
				lis.set(p,x);
			}
		}
		System.out.println(lis.size());
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
