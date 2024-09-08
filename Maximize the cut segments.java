//Day 44 of #CrackYourInternship
class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= n;i++){
            if(i - x >= 0){
                dp[i] = Math.max(dp[i - x] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - x] + 1, dp[i]);
            }
            if(i - y >= 0){
                dp[i] = Math.max(dp[i - y] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - y] + 1, dp[i]);
            }
            if(i - z >= 0){
                dp[i] = Math.max(dp[i - z] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - z] + 1, dp[i]);
            }
        }
        return dp[n] == Integer.MIN_VALUE ? 0 : dp[n];
    }
}
