//Day 45 of #CrackYourInternship
class Solution {
    Set<List<Integer>> result;
    private void helper(int[] nums, int index, List<Integer> curr){
        result.add(new ArrayList<>(curr));
        for(int i = index;i < nums.length;i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            curr.add(nums[i]);
            helper(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        result = new HashSet<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }
}
