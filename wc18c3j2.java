package olympiads;

import java.io.*;
import java.util.*;

public class wc18c3j2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n=readInt();
		int max=0;
		int max2=0;
		for (int i=0;i<n;i++) {
			int f=readInt();
			if (f<=100) {
				if (f>max) {
					max2=max;
					max=f;
				}
				else if (f>max2) {
					max2=f;
				}
			}
		}
		System.out.print(max+max2);
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
