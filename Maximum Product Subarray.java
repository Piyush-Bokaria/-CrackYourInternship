//Day 44 of #CrackYourInternship
class Solution {
    public int maxProduct(int[] nums) {
        int p = 1;
        int s = 1;
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            if(p == 0){
                p = 1;
            }
            if(s == 0){
                s = 1;
            }
            p *= nums[i];
            s *= nums[n - i - 1];
            maxi = Math.max(maxi, Math.max(p, s));
        }
        return maxi;
    }
}
