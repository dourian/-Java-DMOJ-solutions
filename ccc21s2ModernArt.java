package olympiads;
import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Feb. 20, 2021
 * https://dmoj.ca/problems/ccc21s2
 * Simple Trick
 */

public class ccc21s2ModernArt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int m=readInt(), n =readInt();
		int [] c  = new int [n+1];
		int [] r  = new int [m+1];
		int oddcol=0;
		int ans=0;
		int t = readInt();
		
		for (int i=0;i<t;i++) {
			char x = readChar();
			int y = readInt();			
			if (x=='R') {
				r[y]++;
			}
			else {
				c[y]++;
			}
		}
		for (int i=1;i<=n;i++) {
			if (c[i]%2!=0)oddcol++;
		}
		for (int i=1;i<=m;i++) {
			if (r[i]%2==0)ans+=oddcol;
			else ans+=n-oddcol;
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

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
