#include <iostream>
#include <queue>
using namespace std;

struct BstNode
{
	int data;
	BstNode* left;
	BstNode* right;
};

BstNode* GetNewNode(BstNode* root, int data){
	BstNode* newNode = new BstNode();
	newNode->data = data;
	newNode->left = newNode->right = NULL;
	return newNode;
}

BstNode* Insert(BstNode* root, int data){
	if(root==NULL){
		root = GetNewNode(root, data);
	}
	else if (data <= root->data){
		root->left = Insert(root->left, data);
	}
	else{
		root->right = Insert(root->right, data);
	}
	return root;
}

bool Search(BstNode* root, int data){
	if (root == NULL){
		return false;
	}
	else if(data == root->data){
		return true;
	}
	else if(data < root->data){
		return Search(root->left,data);
	}
	else{
		return Search(root->right,data);
	}

}

int FindMin(BstNode* root){
	if (root == NULL)
	{
		cout << "Empty tree";
		return -1;
	}
	while(root->left != NULL){
		root = root->left;
	}
	return root->data;
}

int FindMax(BstNode* root){
	if (root == NULL)
	{
		cout << "Empty tree";
		return -1;
	}

	while(root->right != NULL){
		root = root->right;
	}
	return root->data;
}

int FindHeight(BstNode* root){
	if (root == NULL) return -1;
	int leftHeight = FindHeight(root->left);
	int rightHeight = FindHeight(root->right);
	return max(leftHeight, rightHeight) + 1;
}

void LevelTransversal(BstNode* root){
	if (root == NULL) return;
	queue<BstNode*> Q;
	Q.push(root);

	while(!Q.empty()){
		BstNode* current = Q.front();
		cout << current->data << " ";
		
		if(current->left != NULL)
			Q.push(current->left);
		if(current->right != NULL)
			Q.push(current->right);
		
		Q.pop();
	} 
}

void PreOrderTransversal(BstNode* root){
	if (root == NULL) return;
	cout<<root->data<< " ";
	PreOrderTransversal(root->left);
	PreOrderTransversal(root->right);
}

int main(int argc, char const *argv[])
{
	BstNode* root = NULL;
	root = Insert(root,15);	
	root = Insert(root,10);	
	root = Insert(root,20);
	root = Insert(root,25);
	root = Insert(root,8);
	root = Insert(root,12);

	cout << "Min Value of BST = " << FindMin(root) <<"\n";
	cout << "Max Value of BST = " << FindMax(root) <<"\n";
	cout << "Height of the BST = " << FindHeight(root) <<"\n";
	cout << "\n";

	cout << "BFS Tree transversal: ";
	LevelTransversal(root);
	cout << "\n\n";

	cout << "Pre Order: ";
	PreOrderTransversal(root);
	cout << "\n\n";

	int number;
	cout<<"Enter number be searched\n";
	cin>>number;

	if(Search(root,number) == true) cout<<"Found\n";
	else cout<<"Not Found\n";
	
	return 0;
}