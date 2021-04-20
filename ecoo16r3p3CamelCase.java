package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Apr. 10, 2021
 * https://dmoj.ca/problem/ecoo16r3p3
 * DP
 * 
 * dp state: dp[i]: min # of capitalization we need from beginning to pos i
 * 
 */

public class ecoo16r3p3CamelCase {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		Set <Long> ts = new HashSet <Long>();
		
		for (int i=0;i<n;i++) {
			Long a = hash(readLine());
			ts.add(a);
		}
		for (int t=0;t<10;t++) {
			String s = readLine();
			int m = s.length();
			int [] dp = new int [m+1];
			long hash[] = new long [s.length()+1], pw[] = new long[s.length() + 1], base = 131;
			pw[0]=1;
			for (int i=1;i<=s.length();i++) {
				hash[i]= hash[i-1]*base + s.charAt(i-1);
				pw[i]= pw[i-1]*base;
			}
			
			Arrays.fill(dp, Integer.MAX_VALUE/2); dp[0]=0;
			for (int i=1;i<=m;i++) {
				for (int j=1;j<=1;j++) {
					long sub = hash[i]- hash[j-1]*pw[i-j+1];
					if (ts.contains(sub)) {
						dp[i] = Math.min(dp[i], dp[j-1]+1);
					}
				}
			}
			System.out.println(dp[m]-1);
		}
	}
	static long hash (String s) {
		long h = 0, base =131;
		for (int i=0;i<s.length();i++) {
			h = h*base+s.charAt(i);
		}
		return h;
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
