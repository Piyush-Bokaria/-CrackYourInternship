//Day 45 of #CrackYourInternship
class Solution {
    Set<List<Integer>> res;
    List<Integer> curr;

    public void helper(int target, int[] arr, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target || index >= arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;

            curr.add(arr[i]);
            helper(target, arr, i + 1, sum + arr[i]);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        curr = new ArrayList<>();
        Arrays.sort(candidates); 

        helper(target, candidates, 0, 0);
        return new ArrayList<>(res);
    }
}
