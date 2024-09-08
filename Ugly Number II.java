//Day 44 of #CrackYourInternship
class Solution {
    int[] ugly = new int[1690];
    private void helper(){
        int p2 = 0, p3 = 0, p5 = 0;
        ugly[0] = 1;
        for(int i = 1;i < 1690;i++){
            int next = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            ugly[i] = next;
            if(next == ugly[p2] * 2){
                p2++;
            }
            if(next == ugly[p3] * 3){
                p3++;
            }
            if(next == ugly[p5] * 5){
                p5++;
            }
        }
    }
    public int nthUglyNumber(int n) {
        helper();
        return ugly[n - 1];
    }
}
