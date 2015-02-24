import java.util.Scanner;

public class GraphWdfs{
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	private int count;
	private boolean[] marked;

	public GraphWdfs()
	{ }

	@SuppressWarnings("unchecked")
	public GraphWdfs(int V){
		this.V = V;
		adj = (Bag<Integer>[]) new Bag<?>[V];
		for(int v = 0; v<V; v++){
			adj[v] = new Bag<Integer>();
		}
	}

	public GraphWdfs(Scanner in){
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

	public int count(){
		return count;
	}

  public boolean marked(int v) {
      return marked[v];
  }

	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
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

	public void depthFirstSearch(GraphWdfs G, int s){
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(GraphWdfs G, int v){
		marked[v] = true;
		count++;
		for (int w : G.adj[v]) {
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GraphWdfs G = new GraphWdfs(in);
		int s = Integer.parseInt(args[0]);
		System.out.println(G);
		GraphWdfs search = new GraphWdfs();
		search.depthFirstSearch(G,s);
		for (int v = 0; v< G.V(); v++) {
			if (search.marked(v)){
				System.out.print(v + " ");
			}
		}
    System.out.println();
    if (search.count() != G.V()) System.out.println("NOT connected");
    else System.out.println("connected");
	}

}