//Day 42 of #CrackYourInternship
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    private Node dfs(Node head) {
        Node curr = head;
        Node last = head; 

        while (curr != null) {
            Node next = curr.next; 

            if (curr.child != null) {
                Node childTail = dfs(curr.child); 

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null; 

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
            } else {
                last = curr; 
            }

            curr = next;
        }

        return last;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        dfs(head);
        return head;
    }
}
