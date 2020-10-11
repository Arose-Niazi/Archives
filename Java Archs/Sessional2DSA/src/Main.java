
public class Main {
    public static void main(String[] args)
    {
        BinaryTree a = new BinaryTree();

        a.insert(14);
        a.insert(12);
        a.insert(3);
        a.insert(54);
        a.insert(19);
        a.insert(17);
        a.insert(18);
        a.insert(43);
        a.insert(45);
        a.insert(55);

        a.delete(54);

        System.out.println("\nThe prefix elements are ");
        a.preorder(a.root);

        System.out.println("\nThe post fix elements are ");
        a.postorder(a.root);

        System.out.println("\nThe in fix elements are ");
        a.inorder(a.root);

        System.out.println("The maximum number in the tree is :"+a.findMax(a.root , a.root.data));

        System.out.println("The minimum number in the tree is :"+a.findMin(a.root , a.root.data));

        if(a.completeTree())
        {
            System.out.println("The given tree is a complete binary tree ");
        }
        else
        {
            System.out.println("The given tree is not a complete binary tree ");
        }

        if(a.hasSibling(54))
        {
            System.out.println("The 54 node of tree has a sibling");
        }
        else
        {
            System.out.println("The 54 node of tree does not has a sibling");
        }

        a.search(a.root,12);
        a.search(a.root,14);
        a.exists(a.root,54);

        System.out.println("Height of tree is : " + a.height(a.root));

        System.out.println("The leaf count of binary tree is : "+ a.getLeafCount());

        System.out.println("Level order traversal of binary tree is ");
        a.printLevelOrder();

        System.out.println("\nPrinting left view: ");
        a.leftView();

        System.out.println("\nPrinting right view: ");
        a.rightView();


    }

}
