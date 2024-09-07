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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
        q.offer(new Pair<>(0, root));

        int ans = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            int leftMostNodeNo = q.peek().getKey();
            int rightMostNodeNo = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                Pair<Integer, TreeNode> rootNode = q.poll();
                TreeNode node = rootNode.getValue();
                int currNodeNo = rootNode.getKey();
                rightMostNodeNo = Math.max(rightMostNodeNo, currNodeNo);

                if (node.left != null) {
                    q.offer(new Pair<>(2 * currNodeNo + 1, node.left));
                }

                if (node.right != null) {
                    q.offer(new Pair<>(2 * currNodeNo + 2, node.right));
                }
            }

            ans = Math.max(ans, rightMostNodeNo - leftMostNodeNo + 1);
        }

        return ans;
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
