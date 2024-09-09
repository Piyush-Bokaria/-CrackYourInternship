//Day 45 of #CrackYourInternship
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int result = 0;
        int last = intervals[0][1];

        for(int i = 1;i < n;i++){
            if(intervals[i][0] < last){
                result++;
            }
            else{
                last = intervals[i][1];
            }
        }
        return result;
    }
}
