//Day 43 of #CrackYourInternship
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> order;
    int index = 0;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        order.add(root.val);
        inorder(root.right);
    }

    private void test(TreeNode root) {
        if (root == null) {
            return;
        }
        test(root.left);
        if (root.val != order.get(index)) {
            root.val = order.get(index);
        }
        index++;
        test(root.right);
    }

    public void recoverTree(TreeNode root) {
        order = new ArrayList<>();
        inorder(root);
        Collections.sort(order);
        test(root);
    }
}
