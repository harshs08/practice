import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch{
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private static final int INFINITY = Integer.MAX_VALUE;

	
	public boolean hasPathTo(int v){
		return marked[v];
	}

	public int distTo(int v){
		return distTo[v];
	}

	public BreadthFirstSearch(int s, Graph G){
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		bfs(s, G);
	}

	public void bfs(int s, Graph G){
		Queue<Integer> Q = new LinkedList<Integer>();
		for (int v=0; v<G.V(); v++) {
			distTo[v] = INFINITY;
		}
		marked[s] = true;
		distTo[s] = 0;
		Q.add(s);

		while(Q.size() > 0){
			int v = Q.remove();
			for (int w : G.adj(v)) {
				if(!marked[w]){
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					Q.add(w);
				}
			}
		}
	}

	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x=v; distTo[x] != 0; x=edgeTo[x])
			path.push(x);
		path.push(x);
		return path;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph G = new Graph(in);
		int source = Integer.parseInt(args[0]);
		System.out.println(G);
		BreadthFirstSearch search = new BreadthFirstSearch(source, G);
		for (int v=0; v<G.V(); v++ ) {
			if(search.hasPathTo(v)){
				System.out.printf("%d to %d (%d) ", source, v, search.distTo(v));
				for( int x : search.pathTo(v)){
					if(x==source) System.out.print(x);
					else System.out.print("-" + x);
				}
				System.out.println();
			}
			else{
				System.out.printf("%d to %d (-): not connected\n", source, v);
			}
		}
	}

}