package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * May 8, 2021
 * https://dmoj.ca/problem/gfssoc3s4
 * bitmask DP
 * 
 * 1. general all Bitmasks for each row
 * 2. run DP row by row dp[r][mask]
 */

public class StarryNight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int R = readInt(), C = readInt(), mod = (int) 1e9+7;
		
		List <Integer> lst = new ArrayList();
		long dp[][] = new long [R][3000];
		long ans=0;
		
		for (int mask = 0; mask<1<<C-2;mask++) {
			if ( (mask & mask<<1) ==0 && (mask & mask<<2) == 0) {
				lst.add(mask); dp[0][lst.size()-1]=1; ans++;
			}
		}
		List<Integer> adj[] = new ArrayList [lst.size()];
		
		for (int i=0;i<lst.size(); i++) {
			adj[i] = new ArrayList(); int mask = lst.get(i);
			for (int j=0;j<lst.size();j++) {
				int mask2 = lst.get(j),  nmask = mask2 | mask2<<1 | mask2>>1;
				if ((nmask & mask) == 0) adj[i].add(j);
			}
		}
		ans -= 1;
		for (int r=1; r<R-1;r++) {
			for ( int i=0;i<lst.size();i++) {
				for (int j:adj[i]) {
					dp[r][i]+=dp[r-1][j];
				}
				dp[r][i]%=mod;
				ans = (ans + dp[r][i]) %mod;
			}
			ans = (ans - dp[r][0] +mod ) %mod;
		}
		System.out.println(ans);
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
