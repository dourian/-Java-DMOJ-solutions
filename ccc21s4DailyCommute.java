package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Feb. 20, 2021
 * https://dmoj.ca/problem/ccc21s4
 * BFS + Sorted Set
 */

public class ccc21s4DailyCommute {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int [] dst;
	static int []  rt;
	static int []  index;
	static ArrayList <Integer> [] radj;
	public static void main(String[] args) throws IOException {

		SortedSet<edge> ts = new TreeSet<edge>();

		int N = readInt(), W = readInt(), D = readInt();
		
		dst = new int [N+1];
		rt  = new int [N+1];
		index  = new int [N+1];
		
		
		Arrays.fill(dst, 1000000);
		radj = new ArrayList [N+1];
		
		for (int i=1;i<=N;i++) radj[i]=new ArrayList ();
		
		for (int i=0;i<W;i++) {
			int a=readInt();
			int b=readInt();
			radj[b].add(a);
		}
		bfs(N);

		for (int i=1;i<=N;i++) {
			int x = readInt();
			rt[i]=x;
			index[x]=i;
		}
		for (int i=1;i<=N;i++) {
			ts.add(new edge(index[i]+dst[i],i));
		}
		for (int j=0;j<D;j++) {
			int a=readInt(), b=readInt();
			int numa=rt[a];
			int numb=rt[b];
			
//			System.out.println(numa+" "+numb);
//			System.out.println("indx: "+index[numa] + "dst: "+dst[numa]);
//			System.out.println("indx: "+index[numb] + "dst: "+dst[numb]);
			
			ts.remove(new edge(index[numa]+dst[numa],numa));
			ts.remove(new edge(index[numb]+dst[numb],numb));
//			System.out.println("remove " + ts.size());
			
			int temp = rt[a];
			rt[a]=rt[b];
			rt[b]=temp;
			
//			for (int e=1;e<=N;e++) System.out.print(rt[e]+ " ");
//			System.out.println();
			
			temp = index[numa];
			index[numa]=index[numb];
			index[numb]=temp;
			
//			for (int e=1;e<=N;e++) System.out.print(index[e]+ " ");
//			System.out.println();
			
			if (ts.add(new edge(index[numa]+dst[numa],numa)) ) {
//				System.out.println("YES");
			}
			if (ts.add(new edge(index[numb]+dst[numb],numb)) ) {
//				System.out.println("ok");
			}
//			System.out.println("after "+ ts.size());
			System.out.println(ts.first().f1-1);
		}
	}
	public static void bfs (int N) {
		boolean [] vst=new boolean [N+1];
		Queue <Integer> q = new LinkedList ();
		q.add(N);
		vst[N]=true;
		int d=0;
		while (!q.isEmpty()) {
			int s = q.size();
			d++;
			for (int i=0;i<s;i++) {
				int cur=q.poll();
				for (int x:radj[cur]) {
					if (!vst[x]) {
						q.add(x);
						dst[x]=d;
						vst[x]=true;
					}
				}
			}
		}
		dst[N]=0;
	}
	static class edge implements Comparable <edge> {
		int f1,s1;
		edge(int f,int s) {
			f1 = f; s1 = s;
		}
		public int compareTo (edge x) { 
			if (f1!=x.f1) {
				return f1-x.f1;
			}
			else {
				return s1-x.s1;
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
