package olympiads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc20s1SurmisingaSprintersSpeed {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int [] a;
	static int [] d;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		a = new int [n];
		d = new int [n];
		for (int i=0;i<n;i++) {
			a[i]=readInt();
			d[i]=readInt();
		}
		partition(1,n-1);
		double max = Integer.MIN_VALUE;
		for (int i=1;i<n;i++) {
			double speed = Math.abs((d[i]-d[i-1]))/(a[i]-a[i-1]);
			System.out.println(speed);
			if (speed>max) max = speed;
		}
		System.out.println(max);
	}
	public static void swap(int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
		int temp2 = d[i];
		d[i] = d[j];
		d[j] = temp2;
	}
	public static int partition(int low, int high)
	{
		int pivot = a[low];
		int i = low - 1;
		int j = high + 1;
		while (i < j)
		{
			for (i++; a[i] < pivot; i++);
			for (j--; a[j] > pivot; j--);
			if (i < j)
				swap(i, j);
		}
		return j;
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
