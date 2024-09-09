//Day 45 of #CrackYourInternship
/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution {
    Node compute(Node head) {
        // your code here
        head = reverse(head);
        
        Node res = head;
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.data > temp.next.data){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return reverse(head);
    }
    Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
