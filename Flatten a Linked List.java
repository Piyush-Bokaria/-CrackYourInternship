//Day 42 of #CrackYourInternship
class Solution {
    // Function to flatten a linked list
    private Node merge(Node t1, Node t2){
        Node buffer = new Node(-1);
        Node temp = buffer;
        while(t1 != null && t2 != null){
            if(t1.data < t2.data){
                temp.bottom = t1;
                t1 = t1.bottom;
            }
            else{
                temp.bottom = t2;
                t2 = t2.bottom;
            }
            temp = temp.bottom;
        }
        while(t1 != null){
            temp.bottom = t1;
            t1 = t1.bottom;
            temp = temp.bottom;
        }
        while(t2 != null){
            temp.bottom = t2;
            t2 = t2.bottom;
            temp = temp.bottom;
        }
        return buffer.bottom;
    }
    Node flatten(Node head) {
        // code here
        Node root = head;
        while(root.next != null){
            Node n = root.next;
            root.next = root.next.next;
            root = merge(root, n);
        }
        return root;
    }
}
