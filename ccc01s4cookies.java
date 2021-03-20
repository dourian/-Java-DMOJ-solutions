package olympiads;

/*
 * Dorian Chen
 * Feb 13 2021
 * https://dmoj.ca/problem/ccc01s4
 * simple math
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ccc01s4cookies {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n=readInt();
		double diameter=0;
		ArrayList <edge> adj = new ArrayList ();
		for (int i=0;i<n;i++) {
			int x=readInt(),y=readInt();
			adj.add(new edge(x,y));
		}
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				double d =  Math.sqrt( Math.pow( (adj.get(i).v)-(adj.get(j).v),2)+(adj.get(i).w)-(adj.get(j).w));
				if ( d>diameter) diameter=d;
			}
		}
		System.out.printf("%.2f",diameter);
	}
	static class edge{
		int v,w;
		edge(int v0,int w0) {v=v0;w=w0;}
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
