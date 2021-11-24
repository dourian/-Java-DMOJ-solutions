package olympiads;

import java.util.*;
import java.io.*;

public class dmopc20c3p5TowerOfPower {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		
		int [] a = new int [N];
		
		for (int i=0;i<N;i++) {
			int x = readInt();
			a[i]=x;
		}
		System.out.println((long)Math.pow(a[0], Math.pow(a[1], a[2]))%M);
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
