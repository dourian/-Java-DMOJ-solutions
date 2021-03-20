package olympiads;

import java.io.*;
import java.util.*;
/*
 * Dorian Chen
 * Feb. 19, 2021
 * https://dmoj.ca/problem/ccc05j3
 * Implementation
 */

public class ccc05j3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String line = "";
		ArrayList <Character> d = new ArrayList();
		ArrayList <String> l = new ArrayList();
		
		int count=0;
		while (!line.equals("SCHOOL")) {
			char c = readChar();
			d.add(c);
			line = readLine();
			l.add(line);
			count++;
		}
		for (int i=count-1;i>0;i--) {
			if (d.get(i)=='R') {
				System.out.println("Turn LEFT onto "+l.get(i-1)+" street.");
			}
			else if (d.get(i)=='L') {
				System.out.println("Turn RIGHT onto "+l.get(i-1)+" street.");
			}
		}
		if (d.get(0)=='R') {
			System.out.println("Turn LEFT into your HOME.");
		}
		else if (d.get(0)=='L') {
			System.out.println("Turn RIGHT into your HOME.");
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

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
