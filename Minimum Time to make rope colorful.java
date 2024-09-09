//Day 45 of #CrackYourInternship
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int result = 0;
        int time = neededTime[0];
        int n = colors.length();
        for(int i = 1;i < n;i++){
            if(colors.charAt(i) == colors.charAt(i - 1)){
                result += Math.min(neededTime[i], time);
                time = Math.max(neededTime[i], time);
            }
            else{
                time = neededTime[i];
            }
        }
        return result;
    }
}
