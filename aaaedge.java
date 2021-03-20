package olympiads;

public class aaaedge {

	static class edge implements Comparable <edge> {
		int v,w;
		edge(int f,int s) {
			v = f; w = s;
		}
		public int compareTo (edge x) { 
			return Integer.compare(w, x.w);
			}
	}

}
