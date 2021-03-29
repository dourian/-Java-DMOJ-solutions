package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Mar. 27, 2021
 * https://dmoj.ca/problem/attraction
 * Greedy + Some thinking : ) orz bruce
 */

public class attraction {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		for (int T = readInt(); T>0;T--) {
			int N = readInt(), A = readInt(), B = readInt(), p[] = new int [A], ans =0;
			
			for (int i=0;i<A;i++) p [i] = readInt();
			Arrays.sort(p);
			PriorityQueue <pair> q = new PriorityQueue();
			if (p[0]>1)q.add(new pair (p[0]-1,0)); //0 is endpoint
			if (p[A-1]<N)q.add(new pair (N-p[A-1],0));
			for (int i=1;i<A;i++) {
				if (p[i] == p[i-1]+1) continue;
				int gap = p[i]-p[i-1]-1;
				if (gap%2!=0) q.add(new pair ((gap+1)/2,3));//3 is odd 1st attractor
				else q.add(new pair (gap/2,2)); //2 is even 1st attractor
			}
			while (!q.isEmpty() && B>0) {
				pair cur = q.poll(); ans+=cur.v; B--; 
				if (cur.s==3 && cur.v >= 2) q.add(new pair (cur.v-2,1)); //1 is odd 2nd attractor
				if (cur.s==2) q.add(new pair (cur.v,0)); //even 2nd attractor
				if (cur.s==1) q.add(new pair (1,0));
			}
			System.out.println(ans);
		}
		
	}
	static class pair implements Comparable <pair>{
		int v,s;

		pair(int v0, int s0){
			v=v0;s=s0;
		}
		public int compareTo(pair x) {
			return Integer.compare(x.v, v);
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


