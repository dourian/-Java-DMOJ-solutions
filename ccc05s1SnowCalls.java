package olympiads;

import java.util.*;
import java.io.*;
/*
 * Dorian Chen
 * Feb. 19, 2021
 * 
 * 
 */
public class ccc05s1SnowCalls {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int [] al = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		int t =readInt();
		for (int i=0;i<t;i++) {
			char [] a = readLine().toCharArray();
			String out ="";
			int count=0;
			for (int j=0;j<a.length;j++) {
				if (Character.isAlphabetic(a[j])) {
					out+=(al[a[j]-'A']);
					count++;
				}
				else if(Character.isDigit(a[j])) {
					out+=a[j];
					count++;
				}
				if (count>=10) break;
			}
			for(int k=0;k<3;k++) {
				System.out.print(out.charAt(k));
			}
			System.out.print('-');
			for(int k=3;k<6;k++) {
				System.out.print(out.charAt(k));
			}
			System.out.print('-');
			for(int k=6;k<10;k++) {
				System.out.print(out.charAt(k));
			}
			System.out.println();
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
