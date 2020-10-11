
public class LinkedListClass {
    LinkedListNode head;

    public void Create(int data_entry) {

        LinkedListNode node = new LinkedListNode();

        node.data = data_entry;
        node.next = null;

        if (head == null) {
            head = node;
        } else {

            LinkedListNode n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertion_at_the_start(int data_entry) {

        LinkedListNode node = new LinkedListNode();

        node.data = data_entry;
        node.next = null;

        node.next = head;
        head = node;
    }

    public void insert(int index, int data_entry) {

        LinkedListNode node = new LinkedListNode();

        node.data = data_entry;
        node.next = null;

        LinkedListNode n = head;

        if (index == 0) {
            insertion_at_the_start(data_entry);
        }

        try {
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        } catch (NullPointerException e) {
            System.out.println("This index does not exist");
        }

    }

    public void remove(int index) {
        try {
            if (index == 0) {
                head = head.next;
            } else {
                LinkedListNode n = head;
                LinkedListNode n1 = null;
                for (int i = 0; i < index - 1; i++) {
                    n = n.next;
                }
                n1 = n.next;
                n.next = n1.next;
            }
        } catch (NullPointerException e) {
            System.out.println("This index does not exist");
        }
    }

    public int search(int data) {
        LinkedListNode current = head;
        int i = 0;

        if (head == null) {
            System.out.println("List is empty");
            return -1;
        } else {
            while (current != null) {
                if (current.data == data) {
                    return i;
                }
                i++;
                current = current.next;
            }
        }
        System.out.println("Not found!");
        return -1;
    }

    public void display_linkedlist() {
        LinkedListNode node = head;

        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }

        System.out.println(node.data);
    }

    void printMiddle() {
        LinkedListNode slow_ptr = head;
        LinkedListNode fast_ptr = head;
        if (head != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.data + "] \n");
        }
    }

    public void deleteMiddle() {

        if (head == null) {
            System.out.println("List is emplty");
            return;
        } else if (head.next == null) {
            head = null;
            return;
        } else {
            int count = 0;
            int nodeDeleteIndex = 0;
            LinkedListNode node = this.head;
            LinkedListNode temp = this.head;


            while (node != null) {
                count++;
                node = node.next;
            }

            nodeDeleteIndex = (count / 2);
            for (int i = 0; i < nodeDeleteIndex - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void sortList() {

        LinkedListNode current = head, index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {

                index = current.next;

                while (index != null) {

                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    void removeDuplicates() {

        LinkedListNode curr = head;


        while (curr != null) {
            LinkedListNode temp = curr;

            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = curr.next;
        }
    }

    public int smallestElement(LinkedListNode head) {
        int min = Integer.MAX_VALUE;
        while (head != null) {
            if (min > head.data) {
                min = head.data;
            }
            head = head.next;
        }
        return min;
    }
}