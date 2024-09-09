//Day 45 of #CrackYourInternship
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        } 
        int p = 0;
        int val = 0;
        int n = arr.size();
        for(int i = n - 1;i >= 0;i--){
            val += arr.get(i) * (int) Math.pow(2, p++);
        }
        return val;
    }
}
