//Day 45 of #CrackYourInternship
class Solution {
    
    private static boolean check(int index, int ind, String s, int[][] dp){
        if(dp[index][ind] != 0){
            return dp[index][ind] == 1;
        }
        while(index < ind){
            if(s.charAt(index) != s.charAt(ind)){
                dp[index][ind] = -1;
                return false;
            }
            index++;
            ind--;
        }
        dp[index][ind] = 1;
        return true;
    }
    private static void helper(ArrayList<String> curr, int n, String s, ArrayList<ArrayList<String>> result, int index, int[][] dp){
        if(index == n){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = index; i < n;i++){
            if(check(index, i, s, dp)){
                curr.add(s.substring(index, i + 1));
                helper(curr, n, s, result, i + 1, dp);
                curr.remove(curr.size() - 1);
            }
        }
    }
    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        // code here
        int n = s.length();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int[][] dp = new int[n][n];
        
        helper(new ArrayList<String>(), n, s, result, 0, dp);
        return result;
    }
};
