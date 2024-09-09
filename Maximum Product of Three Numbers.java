//Day 45 of #CrackYourInternship
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int max1, max2, max3;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        int min1, min2, min3;
        int k = -1;
        min1 = min2 = min3 = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            if(nums[i] > 0){
                k = 1;
            }
            if(nums[i] >= max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] >= max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] >= max3){
                max3 = nums[i];
            }
            if(nums[i] <= min1){
                min3 = min2;
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i] <= min2){
                min3 = min2;
                min2 = nums[i];
            }
            else if(nums[i] <= min3){
                min3 = nums[i];
            }
        }
        if(min1 > 0){
            min1 = 0;
        }
        if(min2 > 0){
            min2 = 0;
        }
        if((min1 * min2 > max1 * max2 || min1 * min2 > max2 * max3) && k != -1){
            return min1 * min2 * max1;
        }
        return max1 * max2 * max3;

    }
}
