import java.util.Scanner;

public class Graph{
	private final int V;
	private int E;
	private Stack<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int V){
		this.V = V;
		adj = (Stack<Integer>[]) new Stack<?>[V];
		for(int v = 0; v<V; v++){
			adj[v] = new Stack<Integer>();
		}
	}

	public Graph(Scanner in){
		this(in.nextInt());
		int E = in.nextInt();
		for(int i = 0; i<E; i++){
			int v = in.nextInt();
			int w = in.nextInt();
			addEdge(v,w);
		}
	}

	public int V(){
		return V;
	}

	public int E(){
		return E;
	}

	public void addEdge(int v, int w){
		adj[v].push(w);
		adj[w].push(v);
		E++;
	}

	public Iterable<Integer> adj(int v){
		return adj[v];
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

		 public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			Graph G = new Graph(in);
			System.out.println(G);
		}
}