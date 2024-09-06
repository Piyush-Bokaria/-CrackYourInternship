//Day 42 of #CrackYourInternship
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
    
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }
        slow = head;
        fast = prev;
        while(slow != null && fast != null){
            ListNode curr1 = slow.next;
            ListNode curr2 = fast.next;
            slow.next = fast;
            fast.next = curr1;
            slow = curr1;
            fast = curr2;
        }
    }
}
