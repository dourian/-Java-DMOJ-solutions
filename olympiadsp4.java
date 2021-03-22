package olympiads;

import java.util.*;
import java.io.*;

public class olympiadsp4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), s=readInt();
		String [] w = new String [n+1];
		TreeSet<edge> ts = new TreeSet<edge>();
		int [][] pal = new int [s+1][s+1];
		int ans=0;
		
		for (int i=1;i<=n;i++) {
			w[i]=readLine();
		}
		
		for (int i=1;i<=m;i++) {
			ts.add(new edge(readInt(),readInt()));
		}
//		System.out.println(ts.first().f1);
		
		for (int i=1;i<=n;i++) {
			String word = w[i];
			for (int j=0;j<s;j++) {
				for (int k=j;k<s;k++) {
					pal[j+1][k+1]=ispal(word.substring(j, k+1));
				}
			}
			
//			for (int j=1;j<=s;j++) {
//				for (int k=1;k<=s;k++) {
//					System.out.print(pal[j][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			Iterator<edge> iterator = ts.iterator(); 
			
			while( iterator.hasNext()) {
				edge cur = iterator.next();
//				ts.remove(cur);
				if (!(pal[cur.f1][cur.s1]==1)) {
					break;
				}
				if (!(iterator.hasNext())) ans++;
			}
		}
		System.out.println(ans);
	}
	public static int ispal (String s) {
		boolean flag = true;
		int len = s.length();
		for (int i=0;i<len/2;i++) {
			if (!(s.charAt(i)==s.charAt(len-i-1))) {
				return 0;
			}
		}
//		System.out.println(s+" "+flag);
		return 1;
	}
	static class edge implements Comparable <edge> {
		int f1,s1;
		edge(int f,int s) {
			f1 = f; s1 = s;
		}
		public int compareTo (edge x) { 
			if (f1!=x.f1) {
				return f1-x.f1;
			}
			else {
				return s1-x.s1;
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
