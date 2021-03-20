package olympiads;

/*
 * Dorian Chen
 * Feb 17 2021
 * https://dmoj.ca/problem/lcs
 * DP - LCS
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class longestcommonsubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n =readInt(), m = readInt();
		int [][] c = new int [n+1][m+1];
		int []  ar1 = new int [n+1];
		int []  ar2 = new int [m+1];
		for (int i=1;i<=n;i++) {
			int x = readInt();
			ar1[i]=x;
		}
		for (int i=1;i<=m;i++) {
			int x = readInt();
			ar2[i]=x;
		}
		
		for (int i=0;i<=n;i++) {
			c[i][0]=0;
		}
		for (int i=0;i<=m;i++) {
			c[0][i]=0;
		}
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=m;j++) {
				if(ar1[i]==ar2[j]) {
					c[i][j]=c[i-1][j-1]+1;
				}
				else if (c[i-1][j]>=c[i][j-1]) {
					c[i][j]= c[i-1][j];
				}
				else {
					c[i][j]= c[i][j-1];
				}
			}
		}
		System.out.println(c[n][m]);
		
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
