package olympiads;

import java.io.*;
import java.util.*;

public class bobsChallenge {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(), dp[] = new int [n+1], mod= (int) 1e9+7;
		dp[0]=1;
		for (int i=1;i<=n;i*=2) {
			for (int j=i;j<=n;j++) {
				dp[j] = (dp[j]+dp[j-1]) % mod;
			}
		}
		System.out.println(dp[n]);
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
