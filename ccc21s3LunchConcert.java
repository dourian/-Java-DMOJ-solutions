package olympiads;
import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Feb. 20, 2021
 * https://dmoj.ca/problem/ccc21s3
 * Binary Search --> it is just sorted
 */

public class ccc21s3LunchConcert {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int n, p[], w[], d[];
	public static void main(String[] args) throws IOException {
		n=readInt();
		p =new int[n]; w = new int[n]; d  =new int [n];
		for(int i=0;i<n;i++) {
			p[i]=readInt(); w[i]=readInt(); d[i]=readInt();
		}
		int l =0, r = (int)(1e9)+1, mid=0;
		while(l<r) {
			mid=(l+r)/2;
			if (cost(mid)<cost(mid+1))r=mid;
			else l = mid+1;
		}
		System.out.println(cost(l));
	}
	static long cost (int x) {
		long ans=0;
		for (int i=0;i<n;i++) {
			if (x<p[i]-d[i]) ans+=(long)(p[i]-d[i]-x)*w[i]; //person is on the right of where we search
			if (x>p[i]+d[i]) ans+=(long)(x-p[i]-d[i])*w[i]; //person is on the left of where we search
		}
		return ans;
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
