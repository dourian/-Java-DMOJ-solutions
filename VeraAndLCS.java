package olympiads;
import java.util.*;
import java.io.*;

/*
 * Dorian Chen
 * Feb. 19, 2021
 * https://dmoj.ca/problem/waterloow2017b
 * LCS
 */
public class VeraAndLCS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int a = readInt(), k=readInt();
		String n = readLine();
		char [] word = new char [a];
		char [] word2 = new char [a];
		if (k>a) {
			System.out.println("WRONGANSWER");
			return;
		}
		for (int i=0;i<a;i++) {
			word[i]=n.charAt(i);
		}
		for (int i=0;i<k;i++) {
			
		}
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
