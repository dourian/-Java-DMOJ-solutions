package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Mar. 6, 2021
 * https://dmoj.ca/problem/ccc02s4
 * DP - partition 
 */

public class ccc02s4bridgecrossing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int m = readInt(), n = readInt(), dp[] = new int [n+1], t[] = new int [n+1], prev [] = new int [n+1];
		String name [] = new String [n+1];
		Arrays.fill(dp, Integer.MAX_VALUE); dp[0] = 0;
		for (int i=1; i <=n;i++) {
			name[i] = readLine(); t[i] = readInt();
			int max = t[i];
			for (int j=i-1 ; j>=Math.max(0, i-m);j--) {
				if (dp[j]+max<dp[i]) {
					dp[i] = dp[j]+max; prev[i]=j;
				}
				max = Math.max(max, t[j]);
			}
		}
		System.out.println("Total Time: "+dp[n]);
		List <String> ans = new ArrayList ();
		for (int cur=n;cur!=0; cur=prev[cur]) {
			String tmp="";
			for (int i=prev[cur]+1;i<=cur;i++) tmp +=name[i]+" ";
			ans.add(tmp);
		}
		for (int i=ans.size()-1;i>=0;i--) {
			System.out.println(ans.get(i));
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
