//Day 42 of #CrackYourInternship
class Solution {

    // Helper function to find the maximum value in a subtree
    private static Node findPredecessor(Node node) {
        Node curr = node.left;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    // Helper function to find the minimum value in a subtree
    private static Node findSuccessor(Node node) {
        Node curr = node.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        pre[0] = null;  // Set default values to NULL
        suc[0] = null;

        Node curr = root;

        while (curr != null) {
            if (curr.data == key) {
                // If the key node has a left subtree, find the predecessor (max in left subtree)
                if (curr.left != null) {
                    pre[0] = findPredecessor(curr);
                }
                // If the key node has a right subtree, find the successor (min in right subtree)
                if (curr.right != null) {
                    suc[0] = findSuccessor(curr);
                }
                break;
            } else if (curr.data > key) {
                // If the current node's value is greater than key, it's a potential successor
                suc[0] = curr;
                curr = curr.left;  // Move to the left subtree
            } else {
                // If the current node's value is smaller than key, it's a potential predecessor
                pre[0] = curr;
                curr = curr.right;  // Move to the right subtree
            }
        }
    }
}
