package olympiads;

import java.util.*;
import java.io.*;

public class chrisCandy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long  k =readLong();
		if (k==1) {
			System.out.println("1");
			System.out.println("1");
			return;
		}
		k+=1;
		int a=-1;
		int b=-1;
		for (int i=(int) (k/2);i>=1;i--) {
			if (k%(i*1.0)==0) {
				a=i;
				b=(int) (k/a);
				a-=1;
				b-=1;
				break;
			}
		}
		if (a+b<=(int)1e5 && a!=-1) {
			System.out.println(a+b);
			for (int i=0;i<a;i++) {
				System.out.print("1 ");
			}
			for (int i=0;i<b;i++) {
				System.out.print("2 ");
			}
			System.out.println();
		}
		else {
			System.out.println("Sad Chris");
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
