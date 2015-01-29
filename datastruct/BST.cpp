#include <iostream>
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

int main(int argc, char const *argv[])
{
	BstNode* root = NULL;
	root = Insert(root,15);	
	root = Insert(root,10);	
	root = Insert(root,20);
	root = Insert(root,25);
	root = Insert(root,8);
	root = Insert(root,12);

	cout << "Min Value of BST= " << FindMin(root) <<"\n";
	cout << "Max Value of BST= " << FindMax(root) <<"\n";

	int number;
	cout<<"Enter number be searched\n";
	cin>>number;

	if(Search(root,number) == true) cout<<"Found\n";
	else cout<<"Not Found\n";
	
	return 0;
}