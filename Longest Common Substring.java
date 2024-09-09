//Day 45 of #CrackYourInternship

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxi = 0;
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    if(i != 1 && j != 1 && str1.charAt(i - 2) == str2.charAt(j - 2)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    else{
                        dp[i][j] = 1;
                    }
                }
                else{
                    dp[i][j] = 0;
                }
                if(dp[i][j] > maxi){
                    maxi = dp[i][j];
                }
            }
        }
        return maxi;
    }
}
