package olympiads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dmopc17c2p1_01knapsack {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), maxV = (int) (1e5+1);
		
		long dp[] = new long [N]; 
		Arrays.fill(dp, (long)(2e9));
		dp[0]=0;
		for (int i=0;i<N;i++) {
			int w=readInt(), val=readInt();
			for (int j=N-1;j>=val;j--) {
				dp[j]=Math.min(dp[j], dp[j-val]+w);
			}
		}
		int max=Integer.MIN_VALUE;
		for (int i=N-1;i>=0;i--) {
			if (dp[i]>max) {max=(int) dp[i];}
		}
		System.out.println(max);
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
