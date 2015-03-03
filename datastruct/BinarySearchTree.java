public class BinarySearchTree{
	
	private class Node{
		private int data;
		private Node left;
		private Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private static Node root = null;

	public Node getRoot(){
		return root;
	}

	public void setRoot(Node root){
		this.root = root;
	}

	public Node insert(int data, Node node){
		if(node == null){
			node = new Node(data);
		}
		else if(data <= node.data){
			node.left = insert(data, node.left);
		}
		else{
			node.right = insert(data, node.right);
		}
		return node;
	}

	public void inOrderTransversal(Node node){
	if(node == null) return;
	inOrderTransversal(node.left);
	System.out.print(node.data+" ");
	inOrderTransversal(node.right);
	}

	public boolean search(int data, Node root){
		if(root == null){
			return false;
		}
		else if(data == root.data){
			return true;
		}
		else if(data < root.data){
			return search(data, root.left);
		}
		else{
			return search(data, root.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.setRoot(bst.insert(15, root));
		bst.setRoot(bst.insert(10, root));
		bst.setRoot(bst.insert(20, root));
		System.out.println("Inorder Transversal: ");
		bst.inOrderTransversal(bst.getRoot());
		System.out.println();

		boolean searchRes = bst.search(20, bst.getRoot());
		if(searchRes == true){
			System.out.println("Found");
		}
		else{
			System.out.println("Not Found");
		}
	}
}