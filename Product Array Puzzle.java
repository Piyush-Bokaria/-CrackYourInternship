//Day 45 of #CrackYourInternship
class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long sum = 1;
        int zerocount = 0;
        for(int num : nums){
            if(num == 0){
                zerocount++;
            }
            else{
                sum *= (long) num;
            }
        }
        int n = nums.length;
        long[] result = new long[n];
        for(int i = 0;i < n;i++){
            if(nums[i] == 0){
                if(zerocount > 1){
                    result[i] = 0;
                }
                else{
                    result[i] = (long) sum;
                }
            }
            else{
                if(zerocount > 0){
                    result[i] = 0;
                }
                else{
                    result[i] = (long) (sum / nums[i]);
                }
            }
        }
        return result;
    }
}
