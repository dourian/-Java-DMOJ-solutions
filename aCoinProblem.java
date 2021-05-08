package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 21, 2021
 * https://dmoj.ca/problem/acoinproblem
 * dynamic programming
 */

public class aCoinProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int maxn = (int)10e4;
	public static void main(String[] args) throws IOException {
		int n = readInt(), v = readInt();
		int [] dp = new int [maxn+1];
		int [] num = new int [n+1];
		int [] output = new int [v];
		edge [] ts= new edge [v];
		Arrays.fill(dp, maxn);
		dp[0]=0;
		
		int point=0;
		
		for (int i=1;i<=n;i++) {//taking the numbers
			num[i]=readInt();
		}
		for (int i=0;i<v;i++) {//take queries and put into set
			int t = readInt(), f = readInt();
			ts[i]=(new edge(t,f,i));
		}
		Arrays.sort(ts);
		for (int j=1;j<=n;j++) {//fills dp by first however numbers
			for (int k=0;k<=maxn;k++) {
				if (k+num[j]<=maxn && dp[k]+1<dp[k+num[j]]) {
					dp[k+num[j]]=dp[k]+1;
				}
			}
			for (int i=point;i<v;i++) {
				edge cur = ts[i];
				point=i;
				int fir = cur.f;
				if (fir<j || fir>j) break;
				int tar = cur.t;
				int ot  = cur.o;
				if (dp[tar]<maxn) output[ot]=dp[tar];
				else output[ot]=-1;
			}
		}
		
		for (int i=0;i<v;i++) {
			System.out.println(output[i]);
		}
	}
	static class edge implements Comparable <edge> {
		int t,f, o;
		edge(int fr,int s, int e) {
			t = fr; f = s; o=e;
		}
		public int compareTo (edge x) { 
			return Integer.compare(f, x.f);
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
