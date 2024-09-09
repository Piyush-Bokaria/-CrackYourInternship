//Day 45 of #CrackYourInternship
class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = totalsum(arr);
        
        if(sum % 2 == 1){
            return 0;
        }
        
        int target = sum / 2;
        
        int[] dp = new int[target + 1];
        
        for(int i = 0;i < target + 1;i++){
            if(i == 0){
                dp[i] = 1;
            }
            else{
                dp[i] = 0;
            }
        }
        for(int num : arr){
            Set<Integer> sums = new HashSet<>();
            for(int j = num;j <= target;j++){
                if(dp[j] == 0 && dp[j - num] == 1 && !sums.contains(j - num)){
                    dp[j] = 1;
                    sums.add(j);
                }
                if(dp[target] == 1){
                    return 1;
                }
            }
        }
        return 0;
    }
    static int totalsum(int[] arr){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return sum;
    }
}
