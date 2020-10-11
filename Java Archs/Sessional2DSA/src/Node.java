public class Node {
    int  data;
    Node left_child;
    Node right_child;
    Node parent;

    public Node(int data)
    {
        this.data = data;
        parent=left_child=right_child=null;
    }
}
