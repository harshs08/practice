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

		while(!Q.isEmpty()){
			int v = Q.remove();
			for (int w : G.adj(v)) {
				edgeTo[w] = v;
				distTo[w] = distTo[v] + 1;
				marked[w] = true;
				Q.add(w);
			}
		}
	}

	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x=v; distTo[x] != 0; x=edgeTo[x])
			path.push(x);
		path.push(v);
		return path;
	}

	public static void main(String[] args) {
		
	}

}