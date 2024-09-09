//Day 45 of #CrackYourInternship
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1 == nums2){
            return nums1.length;
        }
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int maxi = 0;
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                maxi = Math.max(maxi, dp[i][j]);
            }
        }
        return maxi;
    }
}
