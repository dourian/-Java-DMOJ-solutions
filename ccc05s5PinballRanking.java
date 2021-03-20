package olympiads;

import java.util.*;
import java.io.*;

public class ccc05s5PinballRanking {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int t=readInt();
		double avg = 0;
		int []  a = new int [t];
		Arrays.fill(a, -1);
		for(int i=0;i<t;i++) {
			int score=readInt();
			a[0]=score;
			Arrays.sort(a);
			int m =a.length;
			avg+=(m-bs(a,m,score))/(t+1.0-1.0);
//			for(int j=0;j<t;j++) {
//				System.out.print(a[j]+" ");
//			}
//			System.out.println();
//			System.out.println(score+" "+bs(a,m,score));
		}
		System.out.printf("%.2f",avg);
	}
	public static int bs (int [] a, int m, int score) {
		int lo=0;
		int hi=m-1;
		while (lo!=hi) {//binary search
			int mid=(hi + lo)/2;
			//System.out.println(mid);
			if (a[mid]>=score) {
				hi=mid;
			}
			else {
				lo=mid+1;
			}
		}
		return hi;
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
