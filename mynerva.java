package olympiads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class mynerva {

	public static class Pair implements Comparable<Pair> {
		int first;
		int second;

		public Pair (int first, int second) {
			this.first = first;
			this.second = second;
		}


		public int compareTo(Pair p) {
			return first - p.first;
		}
	}

	@SuppressWarnings("unchecked")
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int [] ml;
	static int [] minl;
	static int [] dst;
	static int n;
	static int m;
	static ArrayList <Pair> [] adj;

	public static void main(String[] args) throws IOException {
		n = readInt(); m =readInt();
		adj =new ArrayList [n+1];
		ml = new int [n+1];
		minl = new int [n+1];
		dst = new int [n+1];

		for (int i=0;i<n+1;i++) {
			adj[i] = new ArrayList();
			ml[i]=-1;
			minl[i]=100000;
		}
		for (int i=0;i<n;i++) {
			int x=readInt(), y =readInt(), z=readInt();
			adj[x].add(new Pair(y,z));
			adj[y].add(new Pair(x,z));
		}
		for (int i=0;i<m;i++) {




		}
	}
	public static void bfs () {
		boolean vst[] =new boolean [n+1];
		Queue <Pair> que = new LinkedList ();
		que.add(new Pair (1,0));
		vst[1]=true;
		dst[1]=0;
		while(!que.isEmpty()) {
			int size =que.size();
			for (int i=0;i<size;i++) {
				Pair cur = que.poll();
				for (Pair x : adj[cur.first]) {
					int nod = x.first;
					int light = x.second;
					if (!vst[x.first]) {
						vst[x.first]=true;
						que.add(x);
					}
				}
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
