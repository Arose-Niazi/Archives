import java.util.*;

class BST { 

	class Node { 
		int key, balanceFactor;
		Node parent, left, right;

		public Node(int item) { 
			key = item; 
			parent = left = right = null;	
		} 
	} 


	Node root; 

 
	BST() { 
		root = null;
	}

	public int height(Node node) {
		if (node == null)
			return 0;
		else {
			int leftheight = height(node.left);
			int rightheight = height(node.right);

			if (leftheight > rightheight) {
				return (leftheight + 1);

			} else {
				return (rightheight + 1);
			}
		}
	}

	void insert(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}

		Node checking = root;
		Node p;
		do {
			p = checking;
			if (data < checking.key)
				checking = checking.left;
			else
				checking = checking.right;
		}
		while (checking != null);
		Node temp = new Node(data);
		if (data < p.key)
			p.left=temp;
		else
			p.right=temp;
		temp.parent = p;
		System.out.println("Added node with height: " + height(root));
		printLevelOrder();

		Node ubNode;
		do
		{
			calculateBF(root);
			ubNode = locateNodeToWork(root);
			if(ubNode != null) {
				System.out.println("Unbalanced Node Found!!! " + ubNode.key + "\n\tHaving BF: " + ubNode.balanceFactor);

				if (ubNode.left != null) {
					if (ubNode.left.left != null) {
						llRoatation(ubNode.left);
						System.out.println("Fixed LL! ");
						printLevelOrder();
					} else {

					}
				} else {
					if (ubNode.right.right != null) {

					} else {

					}
				}
			}
		}while (ubNode != null);
	}

	void llRoatation(Node left)
	{
		if(left == null) return;
		left.right = left.parent;
		if(left.parent.parent != null)
			if(left.parent.parent.left == left.parent)
			{
				left.parent.parent.left = left;
				left.parent=left.right.parent;
				left.right.parent=left;
			}
			else
			{
				left.parent.parent.right = left;
				left.parent=left.right.parent;
				left.right.parent=left;
			}
		else
		{
			System.out.println("Should Come here");
			root = left;
			System.out.println("\tRoot: " +root.key + "\n\t\tLeft: "+ root.left.key + "\n\t\tRight: "+ root.right.key);
			left.parent=null;
			left.right.parent=left;
			left.right.left=null;
		}
	}

	public void printLevelOrder()
	{
		int h = height(root);
		int i;
		for (i=1; i<=h; i++)
			printGivenLevel(root, i);
	}

	private void printGivenLevel (Node root ,int level)
	{
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.key + " ");
		else if (level > 1)
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}

	void calculateBF(Node n)
	{
		if(n == null) return;
		n.balanceFactor = height(n.left) - height(n.right);
		calculateBF(n.left);
		calculateBF(n.right);
	}

	Node locateNodeToWork(Node n)
	{
		if(n.balanceFactor > 1 || n.balanceFactor < -1)
		{
			Node unbalanced;
			if(height(n.left) > height(n.right))
				unbalanced = locateNodeToWork(n.left);
			else
				unbalanced = locateNodeToWork(n.right);

			if(unbalanced == null)
				return  n;

		}
		return null;
	}
} 
