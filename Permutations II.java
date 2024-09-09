//Day 45 of #CrackYourInternship
import java.util.*;

class Solution {
    List<List<Integer>> result;

    private void helper(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.add(nums[i])) {
                swap(nums, index, i);
                helper(nums, index + 1);
                swap(nums, index, i); 
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums); 
        helper(nums, 0);
        return result;
    }
}
