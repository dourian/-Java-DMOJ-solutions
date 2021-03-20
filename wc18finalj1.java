package olympiads;

import java.util.*;
import java.io.*;

public class wc18finalj1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int [] adj = new int [n+1];

		int max=0;
		int max2=0;
		for (int i =1;i<=n;i++) {
			int w =readInt();
			adj[i] = w;
		}
		Arrays.sort(adj);
		int count=0;
		int prev=adj[1];
		boolean flag=true;
		for (int i=1;i<adj.length;i++) {
			if (adj[i]==prev) {
				count++;
				prev=adj[i];
				flag=true;
			}
			else {
				if (count>max) {
					max2=max;
					max=count;
				}
				else if (count>max2) {
					max2=count;
				}
				count=1;
				prev=adj[i];
				flag=false;
			}
		}
		if (flag && count>max) {
			max2=max;
			max=count;
		}
		else if (flag && count>max2) {
			max2=count;
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
