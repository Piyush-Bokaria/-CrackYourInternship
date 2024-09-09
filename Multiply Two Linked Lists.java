//Day 45 of #CrackYourInternship
class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        //Code here
        long MOD = 1000000007;
        long x = 0;
        long y = 0;
        
        while (first != null) {
            x = ((x * 10) + (long) first.data) % MOD;
            first = first.next;
        }
        
        while (second != null) {
            y = ((y * 10) + (long) second.data) % MOD;
            second = second.next;
        }
        
        return (x * y) % MOD;
    }
}
