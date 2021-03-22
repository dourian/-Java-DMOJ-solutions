package olympiads;

import java.util.*;
import java.io.*;

public class olympiadsp3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static ArrayList <Integer>first = new ArrayList<Integer>();
	static ArrayList <Integer>second = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k=readInt();

		int sum=0;
		ArrayList []adj = new ArrayList [n+1];
		for (int i=1;i<=n;i++) adj[i]= new ArrayList <Integer>();
		for (int i=0;i<m;i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		int [] d1 = bfs(1, n, k, adj);
//		System.out.println();
		int [] d2 = bfs(n, n, k, adj);
		
		d2[n]=k+1;
		d1[1]=k+1;
//		for (int i=1;i<=n;i++) {
//			System.out.println(d1[i]);
//		}
//		System.out.println();
//		for (int i=1;i<=n;i++) {
//			System.out.println(d2[i]);
//		}

		for (int i=1;i<=n;i++) {
			if (d1[i]<=k && d2[i]<=k) {
				sum++;
			}
		}
		
//		for (int i:first) {
//			System.out.println(i);
//		}
//		System.out.println();
//		for (int i:second) {
//			System.out.println(i);
//		}
		long ans=2;
		for (int i=0;i<sum-1;i++) {
			ans*=2;
			ans%=1000000007;
//			System.out.println(ans);
		}
		System.out.println(ans);
	}
	public static int[] bfs (int s, int n, int k, ArrayList <Integer> [] adj) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		ArrayList<Integer> ay = new ArrayList();
		boolean [] checked = new boolean [n+1];
		checked[s]=true;
		int [] d = new int [n+1];
		Arrays.fill(d, k+1);
		
		int current;
		int count=0;
		while(!queue.isEmpty()) {
			int loop = queue.size();
			count++;
			for (int j=0;j<loop;j++) {
				current=queue.poll();
				for (int neighbour: adj[current]) {
//					System.out.println(current+" "+neighbour);
					if (!checked[neighbour]) {
						checked[neighbour]=true;
						queue.add(neighbour);
						d[neighbour]=count;
					}
				}
			}
		}
		return d;
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
