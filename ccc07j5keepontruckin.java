package olympiads;

/*
 * Dorian Chen
 * Feb 7 2021
 * https://dmoj.ca/problem/ccc07j5
 * DP
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc07j5keepontruckin {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a=readInt(), b= readInt(), n=readInt();
		long [] dp1 = new long [15];
		int [] dst1 = {0,0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};

		long [] dp = new long [15+n];
		int [] dst = new int [15+n];
		for (int i=0;i<dst1.length;i++) {
			dst[i]=dst1[i];
		}
		for (int i=1;i<=n;i++) {
			int d = readInt();
			dst[i+14]= d;
		}
		
		Arrays.fill(dp, 0);
		Arrays.sort(dst);
		dp[1]=1;
		for (int i=2;i<dst.length;i++) {
			for (int e=1;e<i;e++) {
				if (dst[i]-dst[e]<=b && dst[i]-dst[e]>=a) {
					dp[i]+=dp[e];
				}
			}
		}
//		System.out.println();
//		for (int i=0;i<dp.length;i++) System.out.printf("%6d",dp[i]);
//		System.out.println();
//		for (int i=0;i<dst.length;i++) System.out.printf("%6d",dst[i]);
//		System.out.println();
		System.out.println(dp[dp.length-1]);
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
