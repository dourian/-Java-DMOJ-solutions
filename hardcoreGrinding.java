package olympiads;

import java.util.*;
import java.io.*;

public class hardcoreGrinding {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int [] m  = new int [(int)1e7+1];
		Arrays.fill(m, 0);
		for (int i=0;i<n;i++) {
			int s = readInt(), f = readInt();
			m[s]=m[s]+1;
			m[f]=m[f]-1;
		}
		int max=0;
		for (int i=1;i<(int)1e7;i++) {
			m[i]+=m[i-1];
			if (m[i]>max) max=m[i];
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
