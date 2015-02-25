import java.util.Scanner;

public class DepthFirstSearch{
	private int count;
	private boolean[] marked;

	public int count(){
		return count;
	}

	public boolean marked(int v){
		return marked[v];
	}

	public DepthFirstSearch(int s, Graph G){
		marked = new boolean[G.V()];
		count ++;
		dfs(s, G);
	}

	public void dfs(int v, Graph G){
		marked[v] = true;
		for (int i : G.adj(v)) {
			if (!marked[i]) {
				dfs(i, G);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Graph G = new Graph(in);
		int s = Integer.parseInt(args[0]);

		DepthFirstSearch search = new DepthFirstSearch(s, G);
		for (int v=0; v<G.V(); v++) {
			if(search.marked(v)){
				System.out.print(v + " ");
			}
		}
		System.out.println();
		if(search.count == G.V()){ System.out.println("Connected");}
		else { System.out.println("Not connected"); }
	}
}