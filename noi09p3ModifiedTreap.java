package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 10, 2021
 * interval DP dp[key from L][key to R][priority W]: best ans
 * dp[L][R][W]
 */


public class noi09p3ModifiedTreap {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int  n , cost, dp[][][], psa[]; static boolean vis[][][]; static E a[];
	
	public static void main(String[] args) throws IOException {
		n = readInt(); cost = readInt(); vis  = new boolean [n+1][n+1][n+1]; dp  = new int [n+1][n+1][n+1]; psa = new int [n+1];
		a = new E [n+1];
		
		for (int i=1;i<=n;i++) a[i] = new E(readInt(), 0 ,0);
		for (int i=1;i<=n;i++) a[i].p = readInt();
		for (int i=1;i<=n;i++) a[i].f = readInt();
		Arrays.sort(a,1,n+1, new cmpPriority());
		for (int i=1;i<=n;i++) a[i].p = i;
		Arrays.sort(a,1,n+1, new cmpKey());
		for (int i=1;i<=n;i++)psa[i] = psa[i-1]+a[i].f;
		System.out.println(fun(1,n,0));
	}
	static int fun(int l, int r, int w) {
		if(l>r) return 0;
		if(vis[l][r][w]) return dp[l][r][w];
		vis[l][r][w] = true; int ans =Integer.MAX_VALUE, sum = psa[r]-psa[l-1];
		for (int m=l;m<=r;m++) {
			ans=Math.min(ans, fun(l,m-1,w) + fun(m+1,r,w)+sum+cost);
			if (a[m].p >= w) ans = Math.min(ans,  fun(l,m-1,a[m].p)+fun(m+1,r,a[m].p)+sum);
		}
		return dp[l][r][w] = ans;
	}
	static class cmpKey implements Comparator<E> {
		public int compare(E a, E b) {
			return Integer.compare(a.k, b.k);
		}
		
	}
	static class cmpPriority implements Comparator<E> {
		public int compare(E a, E b) {
			return Integer.compare(a.p, b.p);
		}
	}
	static class E{
		int k,p,f;
		E(int k0,int p0, int f0){k = k0; p=p0; f=f0;}
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
