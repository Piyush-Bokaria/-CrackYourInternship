//Day 42 of #CrackYourInternship
class Solution {
    void reorderlist(Node head) {
        // Your code here
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        Node prev = null;
        while (fast != null) {
            Node next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }
        slow = head;
        fast = prev;
        while(slow != null && fast != null){
            Node curr1 = slow.next;
            Node curr2 = fast.next;
            slow.next = fast;
            fast.next = curr1;
            slow = curr1;
            fast = curr2;
        }
    }
}
