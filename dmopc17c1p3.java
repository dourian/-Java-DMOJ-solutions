package olympiads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dmopc17c1p3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static ArrayList<edge> []adj;
	static int dng[];
	static int dst[];
	static Queue<Integer>q=new LinkedList();
	public static void main(String[] args) throws IOException {
		int n=readInt(), m=readInt(); dst=new int [n+1]; dng=new int [n+1]; adj = new ArrayList [n+1];

		Arrays.fill(dng, Integer.MAX_VALUE);
		Arrays.fill(dst, 0);
		for (int i=0;i<=n;i++) adj[i]=new ArrayList<edge>();
		for (int i=0;i<m;i++) {
			int a,b,c;
			a=readInt(); b=readInt(); c=readInt();
			a--;
			b--;
			adj[a].add(new edge(b,c));
			adj[b].add(new edge(a,c));
		}
		bfs();

		if (dng[n-1]==Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.print(dng[n-1]+" "+dst[n-1]);
		}
	}
	public static void bfs () {
		q.add(0);
		dng[0]=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (edge e:adj[cur]) {
				int nxt = e.v;
				int c = e.w;
				int nc = dng[cur]+c;
				if (dng[nxt]>nc) {
					dng[nxt] = nc;
					dst[nxt] = dst[cur]+1;
					q.add(nxt);
				}
			}
		}
	}
	static class edge implements Comparable <edge>{
		int v,w;
		edge(int v0,int w0) {v=v0;w=w0;}
		public int compareTo (edge x) { return -Integer.compare(w, x.w);}
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
