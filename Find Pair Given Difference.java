//Day 45 of #CrackYourInternship
class Solution {
    public int findPair(int n, int x, int[] arr) {
        //Code Here
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i] + x) || set.contains(arr[i] - x)) {
                return 1; 
            }
            set.add(arr[i]);
        }
        
        return -1;
    }
}
