package olympiads;

import java.util.*;
import java.io.*;

public class wc18s1conntedcomp {
	static int [] con = new int [100001];
	static boolean [] vst = new boolean [100001];
	static int color=0;
	static ArrayList<Integer> [] adj2;
	static int count=0;
	static char [] planet;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = readInt(); int m = readInt(); int k =readInt();

		ArrayList<Integer> [] adj = new ArrayList [3];
		for (int i=0;i<3;i++) adj[i] = new ArrayList<Integer>(); //creates the stuff
		Arrays.fill(vst, false);
		adj2 = new ArrayList [n+1];
		for (int i=1;i<=n;i++) adj2[i] = new ArrayList <Integer> ();
		planet=new char[n+1];
		String line=readLine(); //take in chars
		char [] race = line.toCharArray();
		
		for (int i=0;i<race.length;i++) {
			char x=race[i];
			planet[i+1]=x;
		}

		for (int i=0;i<m;i++) { //adj matrix of paths
			int a,b;
			a=readInt(); b=readInt();
			if (planet[a]==planet[b]) {
				adj2[a].add(b);
				adj2[b].add(a);
			}
		}

		for (int i=1;i<=n;i++) if (!vst[i]) bfs(i);

		for (int i=0;i<k;i++) {
			int x = readInt(); int y=readInt();
			if (con[x]==con[y]) count++;
		}
		System.out.println(count);
	}
	public static void bfs(int i) {
		color++;
		Stack<Integer> queue = new Stack<Integer>();
		queue.push(i);
		vst[i]=true;
		int current;
		while (queue.isEmpty()==false) {
			current=queue.pop();
			vst[current]=true;
			con[current]=color;
			for (int neighbour: adj2[current]) {
				if (!vst[neighbour]) {
					vst[neighbour]=true;
					queue.push(neighbour);
				}
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
