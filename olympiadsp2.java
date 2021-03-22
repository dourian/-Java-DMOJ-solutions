package olympiads;

import java.util.*;
import java.io.*;

public class olympiadsp2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n =readInt(), d = readInt(), k =readInt();

		if (k>n) System.out.println(0);
		
		long [] m = new long [n+1];
		long moves=0;

		for (int i=1;i<=n;i++) {
			int h =readInt();
			m[i]=h;
		}
		Arrays.sort(m);
		for (int i=n;i>n-k;i--) {
			m[i]=0;
		}
		for (int i=1;i<=n-k;i++) {
			if (m[i]%d==0) {
				moves+=m[i]/d;
			}
			else {
				moves+=m[i]/d+1;
			}
		}
		System.out.println(moves);
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
