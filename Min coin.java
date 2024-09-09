//Day 45 of #CrackYourInternship
class Solution
{
    public int MinCoin(int[] nums, int amount)
    {
        int[][] dp = new int[nums.length + 1][amount + 1];

        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], (int) 1e8);
        }

        // Base case: If the amount is 0, then 0 coins are needed.
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int sum = 1; sum <= amount; sum++) {
                int take=(int)1e8;
                if (nums[i - 1] <= sum) take=0;
                if (nums[i - 1] <= sum) {
                    take=1 + dp[i][sum - nums[i - 1]];
                }
                int nottake=dp[i][sum] = dp[i - 1][sum];
                
                dp[i][sum]=Math.min(take,nottake);
            }
        }

        return (dp[nums.length][amount] == (int) 1e8) ? -1 : dp[nums.length][amount];
    }
}
