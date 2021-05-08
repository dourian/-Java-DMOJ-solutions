package olympiads;

import java.io.*;
import java.util.*;

public class ecoo21p2DNADerren {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String a = readLine();
		char [] let = new char [a.length()+1];
		for (int i=0;i<a.length();i++) {
			if (a.charAt(i)=='A') {
				let[i]='V';
			}
			else {
				let[i]='C';
			}
		}
		let[let.length-1]=let[let.length-2];
		int s=0;
		for (int i=0;i<=a.length();i++) {
			char prev = let[i];
			for (int j=i+1;j<=a.length();j++) {
				char cur=let[j];
				//System.out.println(cur+" "+prev);
				if (cur==prev) {
					System.out.print(a.substring(i,j)+" ");
					i=j-1;
					break;
				}
				prev=cur;
			}
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
