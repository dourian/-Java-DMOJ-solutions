package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 24, 2021
 * https://dmoj.ca/problem/segtree
 * segtree ;w;
 */

public class DynamicRangeMinimumTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int t[];

	public static void main(String[] args) throws IOException {
		int n =readInt(), m = readInt();
		
		t = new int [4*n];
		int [] a = new int [n];
		for (int i=0;i<n;i++) {
			a[i]=readInt();
		}
		build(a, 1, 0, n-1 );
		for (int i=0;i<m;i++) {
			char x = readCharacter();
			if (x=='Q') {
				int l = readInt(), r=readInt();
				//System.out.println(sum(1,0,n-1,l,r));
			}
			else {
				int pos=readInt(), new_val = readInt();
				//update(1,0,n-1,pos,new_val);
			}
		}
	}
	static void build(int a[], int v, int tl, int tr) {
	    if (tl == tr) {
	        t[v] = a[tl];
	    } else {
	        int tm = (tl + tr) / 2;
	        build(a, v*2, tl, tm);
	        build(a, v*2+1, tm+1, tr);
	        t[v] = Math.min(t[v*2],t[v*2+1]);
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
