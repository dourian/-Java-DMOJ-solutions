package olympiads;

/*
 * Dorian Chen
 * Feb 19 2021
 * https://dmoj.ca/problem/dmopc16c1p3
 * DP - Golf with unlimited balls
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class dmopc16c1p3ShoeShopping {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		double [] dp = new double [n+1];
		int [] s = new int [n+1];
		for (int i=1;i<=n;i++) {
			s[i]=readInt();
		}
		dp[1]=s[1];
		for (int i=2;i<=n;i++) {
			if(i>2) {
				double min = dp[i-1]+s[i];
				double num = Math.min(s[i], s[i-1])/2.0 +Math.max(s[i], s[i-1])+dp[i-2];
				if(num<min) {
					min = num;
				}
				if (n>=3) {
					double num2 = s[i]+s[i-1]+s[i-2]+dp[i-3]- Math.min(s[i], Math.min(s[i-1], s[i-2]));
					if(num2<min) {
						min=num2;
					}
				}
				dp[i]=min;
			}
			else {
				dp[i]=Math.min(s[i], s[i-1])/2.0 + Math.max(s[i], s[i-1]);
			}
		}
		System.out.printf("%.1f",dp[n]);
//		for(int i=0;i<=n;i++) {
//			System.out.print(dp[i]+" ");
//		}
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
