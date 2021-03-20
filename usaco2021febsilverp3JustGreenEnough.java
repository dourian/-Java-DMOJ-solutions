package olympiads;

import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Mar. 13, 2021
 * Counting sub grids 2D
 * 
 * Given N x N grid, find out number of sub grids with min = 100:
 */
public class usaco2021febsilverp3JustGreenEnough {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N =readInt(), a[][] = new int [N+1][N+1];
		for (int i=1;i<=N;i++)
			for (int j=1;j<=N;j++)
				a[i][j] = readInt();
		System.out.println(countSubGrids(N,a,100) - countSubGrids(N,a,101));
	}
	static long countSubGrids (int n, int a[][], int min) {
		long ans=0;
		int h[] = new int [n+1];
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=n;j++) {
				if (a[i][j]>=min) h[j]++;
				else h[j]=0;
			}
			for (int j=1;j<=n;j++) {
				int cnt = h[j], low = h[j];
				for (int k=j-1;k>=1;k--) {
					low = Math.min(low, h[k]);
					cnt+=low;
				}
				ans+=cnt;
			}
		}
		return ans;
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
