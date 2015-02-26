import java.util.Scanner;

public class DepthFirstSearch{
	private int count;
	private boolean[] marked;
	private int[] edgeTo;
	private final int s; 

	public int count(){
		return count;
	}

	// public boolean marked(int v){
	// 	return marked[v];
	// }

	public boolean hasPath(int v){
		return marked[v];
	}

	public DepthFirstSearch(int s, Graph G){
		this.s = s;
		marked = new boolean[G.V()];
		count ++;
		dfs(s, G);
	}

	public void dfs(int v, Graph G){
		marked[v] = true;
		for (int i : G.adj(v)) {
			if (!marked[i]) {
				edgeTo[v] = i;
				dfs(i, G);
			}
		}
	}

	public Iterable<Integer> pathTo(int v){
		if(!hasPath(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x!=s; x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph G = new Graph(in);
		int s = Integer.parseInt(args[0]);
		System.out.println(G);
		DepthFirstSearch search = new DepthFirstSearch(s, G);
		// for (int v=0; v<G.V(); v++) {
		// 	if(search.marked(v)){
		// 		System.out.print(v + " ");
		// 	}
		// }
		for (int v=0; v<G.V(); v++) {
			if(search.hasPath(v)){
				System.out.printf("%d to %d:  ", s, v);
				for (int x : search.pathTo(v) ) {
					if (x == s) System.out.print(x);
					else System.out.print("-" + x);
				}
				System.out.println();
			}
			else{
				System.out.println("no path present");
			}
			
		}
		System.out.println();
		if(search.count == G.V()){ System.out.println("Connected");}
		else { System.out.println("Not connected"); }
	}
}