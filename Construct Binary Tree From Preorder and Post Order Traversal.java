//Day 43 of #CrackYourInternship
/**
 * Definition for a binary tree Node.
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
    int preindex;
    TreeNode constructTreeUtil(int pre[], int post[], int l, int h, int size) 
    {
         
        if (preindex >= size || l > h)
            return null;

        TreeNode root = new TreeNode(pre[preindex]);
        preindex++;

        if (l == h || preindex >= size)
            return root;
        int i;
         
        for (i = l; i <= h; i++) 
        {
            if (post[i] == pre[preindex])
                break;
        }
        if (i <= h) 
        {
            root.left = constructTreeUtil(pre, post, l, i, size);
            root.right = constructTreeUtil(pre, post, i + 1, h-1, size);
        }
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preindex = 0;
        int size = preorder.length;
        return constructTreeUtil(preorder, postorder, 0, size - 1, size);
    }
}
