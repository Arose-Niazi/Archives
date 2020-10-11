public class BinaryTree {
    Node root=null;

    void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Node checking = root;
        Node p;
        do {
            p = checking;
            if (data < checking.data)
                checking = checking.left_child;
            else
                checking = checking.right_child;
        }
        while (checking != null);
        Node temp = new Node(data);
        if (data < p.data)
            p.left_child=temp;
        else
            p.right_child=temp;
        temp.parent = p;

        System.out.println("Added node with parent: " + temp.parent.data);

    }

    public void preorder(Node node)
    {
        if(node == null)
                return;

        System.out.print(node.data + "\t");
        preorder(node.left_child);
        preorder(node.right_child);
    }

    public void postorder(Node node)
    {
        if(node == null)
            return;

        postorder(node.left_child);
        postorder(node.right_child);
        System.out.print(node.data + "\t");
    }

    public void inorder(Node node)
    {
        if(node == null)
            return;

        inorder(node.left_child);
        System.out.print(node.data + "\t");
        inorder(node.right_child);
    }

    public int findMin(Node node , int min)
    {
        if(node == null)
            return min;
        else
        {
            if(min>node.data)
            {
                min = node.data;
            }

            min =  findMin(node.left_child ,  min);
            min =  findMin(node.right_child ,  min);
            return min;
        }
    }

    public int findMax(Node node , int max)
    {
        if(node == null)
            return max;
        else
        {
            if(max<node.data) {
                max = node.data;
            }

            max =  findMax(node.left_child ,  max);
            max =  findMax(node.right_child ,  max);

            return max;
        }
    }

    public boolean completeTree()
    {
        return completeTree(root,false);
    }

    private boolean completeTree(Node node , boolean result)
    {
        if(node == null)
            return result;
        else
        {
            if(node.right_child == null && node.left_child != null)
            {
                result = false;
            }

            if(node.left_child == null && node.right_child!=null)
            {
                result = false;
            }

            result = completeTree(node.left_child , result);
            result = completeTree(node.right_child , result);

            return result;
        }
    }

    public void exists(Node node,int val){
        if(node==null)
            return;
        if(node.data == val)
        {
            System.out.println("The value "+node.data+" exists in the tree.");
            return;
        }
        exists(node.left_child,val);
        exists(node.left_child,val);
    }

    public void search(Node node,int val){
        if(node==null)
            return;
        if(node.data == val)
        {
            System.out.println("The value "+node.data+" found:");
            System.out.println("\tThis is root node.");
            System.out.println("\tHeight: " + 0);
            System.out.println("\tLevel: " + 1);

            return;
        }
        search(node.left_child,val,1);
        search(node.left_child,val,1);
    }

    private void search(Node node,int val,int height){
        if(node==null)
            return;
        if(node.data == val)
        {
            System.out.println("The value "+node.data+" found:");
            System.out.println("\tParent: "+node.parent.data);
            if(node.data > node.parent.data)
                if(node.parent.left_child != null)
                    System.out.println("\tLeft Sibling: "+node.parent.left_child.data);
            else
                if(node.parent.right_child != null)
                    System.out.println("\tRight Sibling: "+node.parent.right_child.data);
            System.out.println("\tHeight: " + height);
            System.out.println("\tLevel: " + (height+1));
            return;
        }
        search(node.left_child,val,height+1);
        search(node.left_child,val,height+1);
    }

    public boolean hasSibling(int value)
    {
        return hasSibling(root,false,value);
    }

    private boolean hasSibling(Node node , boolean result , int value)
    {
        if(node == null)
        {
            return result;
        }

        else
        {
            if(node.data == value)
            {
                if(node.left_child != null && node.right_child!=null)
                {
                    result = true;
                }
            }

            result = hasSibling(node.left_child , result , value);
            result = hasSibling(node.right_child , result , value);

            return result;
        }
    }

    public int height(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            int leftheight  = height(node.left_child);
            int rightheight = height(node.right_child);

            if (leftheight > rightheight)
            {
                return (leftheight+1);

            }

            else
            {
                 return (rightheight+1);
            }
        }
    }

    public int getLeafCount()
    {
        return getLeafCount(root);
    }

    private int getLeafCount(Node node)
    {
        if(node == null)
        {
             return 0;
        }

        if(node.left_child == null && node.right_child == null)
        {
            return 1;
        }
        else
        {
            return getLeafCount(node.left_child) + getLeafCount(node.right_child);
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
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left_child, level-1);
            printGivenLevel(root.right_child, level-1);
        }
    }


    private int max_level;
    private void LeftViewNodes(Node node, int level)
    {
        if (node == null)
            return;

        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }
        LeftViewNodes(node.left_child, level + 1);
        LeftViewNodes(node.right_child, level + 1);
    }

    public void leftView()
    {
        max_level = 0;
        LeftViewNodes(root, 1);
    }


    private void rightViewNodes(Node node, int level) {

        if (node == null)
            return;

        if (max_level < level)
        {
            System.out.print(node.data + " ");
            max_level = level;
        }

        rightViewNodes(node.right_child, level + 1);
        rightViewNodes(node.left_child, level + 1);
    }

    public void rightView()
    {
        max_level=0;
        rightViewNodes(root,1);
    }

    public void delete(int data)
    {
        Node checking = root;
        Node p;
        do {
            p = checking;
            if (data < checking.data)
                checking = checking.left_child;
            else if(data > checking.data)
                checking = checking.right_child;
            else break;
        }
        while (checking != null);
        if(data < p.parent.data)
            p.parent.left_child=null;
        else
            p.parent.right_child=null;

        System.out.println("Removed: " + p.data);
        insertAllFromNode(p.left_child);
        insertAllFromNode(p.right_child);
    }

    public void insertAllFromNode(Node node)
    {
        if(node == null)
            return;

        insert(node.data);
        insertAllFromNode(node.left_child);
        insertAllFromNode(node.right_child);
    }
}
