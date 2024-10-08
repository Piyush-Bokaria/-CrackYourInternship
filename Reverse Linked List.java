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
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while(head != null){
            ListNode curr = new ListNode(head.val);
            curr.next = result;
            head = head.next;
            result = curr;
        }
        return result;
    }
}
