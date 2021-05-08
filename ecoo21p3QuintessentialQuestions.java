package olympiads;

import java.util.*;
import java.io.*;

public class ecoo21p3QuintessentialQuestions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(), K = readInt();
		edge [] best = new edge [N+1];
		Arrays.fill(best, new edge(-1,-1) );
		for (int i=0;i<K;i++) {
			int A,B,C;
			A = readInt(); B =readInt(); C = readInt();
			if (best[B].w<C) {
				best[B]=new edge(A,C);
			}
		}
		for (int i=1;i<=N;i++) {
			System.out.print(best[i].v+" ");
		}
	}
	static class edge implements Comparable <edge> {
		int v,w;
		edge(int f,int s) {
			v = f; w = s;
		}
		public int compareTo (edge x) { 
			return Integer.compare(w, x.w);
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
