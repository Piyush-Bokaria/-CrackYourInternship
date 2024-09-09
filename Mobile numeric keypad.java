//Day 45 of #CrackYourInternship
class Solution {
    private static final int[][] keypad = {
        {1, 2, 3},
        {4, 5, 6}, 
        {7, 8, 9}, 
        {-1, 0, -1}
    };
    private static final int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public long getCount(int n) {
        // Your code goes here
        long[][] dp = new long[10][n + 1];
        
        for(int i = 0;i < 10;i++){
            Arrays.fill(dp[i], -1L);
        }
        
        long res = 0;
        
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 3;j++){
                if(keypad[i][j] != -1){
                    res += helper(i, j, n, dp);
                }
            }
        }
        
        return res;
    }
    private long helper(int i, int j, int n, long[][] dp){
        if(n == 1){
            return 1;
        }
        if(dp[keypad[i][j]][n] != -1){
            return dp[keypad[i][j]][n];
        }
        long res = 0;
        res += helper(i, j, n - 1, dp);
        
        for(int k = 0;k < 4;k++){
            int newi = i + dir[k][0];
            int newj = j + dir[k][1];
            
            if(newi >= 0 && newj >= 0 && newi < 4 && newj < 3 && keypad[newi][newj] != -1){
                res += helper(newi, newj, n - 1, dp);
            }
        }
        return dp[keypad[i][j]][n] = res;
    }
}
