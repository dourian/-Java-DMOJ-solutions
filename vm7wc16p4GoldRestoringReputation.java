package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Mar. 6, 2021
 * https://dmoj.ca/problem/vmss7wc16c4p3 
 * Transforming A -> B
 * 
 * similar ot LCS
 * dp [i][j] = min time to convert first i of A to first j of B
 * final ans dp[A][B]
 * 
 * base case: dp[0][j] = insert * j      dp[i][0] = delete * i 
 * if A[i] ==  B[j]    dp[i][j] = dp[i-1][j-1]
 * otherwise 
 * case 1: insert a new character  for b[j]
 *    dp[i][j-1] + insert time 
 * case 2: delete the i-th character in A
 *    dp[i-1][j] + delete time 
 * case 3: replace A[i] to B[j]
 *    dp[i-1][j-1] + replace time 
 * 
 */

public class vm7wc16p4GoldRestoringReputation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int D = readInt(), I = readInt(), R = readInt();
		char [] a = (" " + next()).toCharArray(), b = (" " + next()).toCharArray();
		int n =a.length, m = b.length, dp [] [] = new int [n][m];
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (i==0 && j==0) dp[i][j]=0;
				else if (i==0) dp[i][j] = I *j;
				else if (j==0) dp[i][j] = D *i;
				else {
					if (a[i]==b[j]) dp[i][j] = dp[i-1][j-1];
					else dp[i][j] = Math.min(dp[i][j-1]+I, Math.min(dp[i-1][j]+D, dp[i-1][j-1]+R));
				}
			}
		}
		System.out.println(dp[n-1][m-1]);
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
