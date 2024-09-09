//Day 45 of #CrackYourInternship
class Solution {
    int result;
    private void helper(int[] nums, int n, int curr){
        if(curr >= n + 1){
            result++;
            return;
        }

        for(int i = 1;i <= n;i++){
            if(nums[i] == 0 && (curr % i == 0 || i % curr == 0)){
                nums[i] = curr;
                helper(nums, n,  curr + 1);
                nums[i] = 0;
            }
        }
    }
    public int countArrangement(int n) {
        int[] nums = new int[n + 1];

        result = 0;
        int curr = 1;
        helper(nums, n, curr);
        return result;
    }
}
