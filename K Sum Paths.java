//Day 43 of #CrackYourInternship
class Solution {
    private int result = 0;
    
    private void dfs(Node root, int target, int currSum) {
        if (root == null) {
            return;
        }

        currSum += root.data;

        if (currSum == target) {
            result++;
        }

        dfs(root.left, target, currSum);
        dfs(root.right, target, currSum);
    }
    
    public int sumK(Node root, int k) {
        // code here
        if (root == null) {
            return 0;
        }

        dfs(root, k, 0);

        sumK(root.left, k);
        sumK(root.right, k);

        return result;
    }
}
