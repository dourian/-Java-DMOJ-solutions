package olympiads;
import java.io.*;
import java.util.*;

public class olympiadsq1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long a = readLong();
		long b = readLong();

		long r1=0;
		long r2=0;
		while(a != 0) {
			int digit = (int) (a % 10);
			r1 = r1 * 10 + digit;
			a /= 10;
		}
		while(b != 0) {
			int digit = (int) (b % 10);
			r2 = r2 * 10 + digit;
			b /= 10;
		}
		System.out.println(Math.min(r1, r2));
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
