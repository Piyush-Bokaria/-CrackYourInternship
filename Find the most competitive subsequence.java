//Day 44 of #CrackYourInternship
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + n - i > k) {
                stack.pop();
            }
            stack.push(nums[i]);
        }

        while (stack.size() > k) {
            stack.pop();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
