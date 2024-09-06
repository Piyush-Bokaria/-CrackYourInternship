'''Day 42 of #CrackYourInternship'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if not head or (not head.next and n==1):
            return head.next
        buffer=ListNode(-1,head)
        temp=temp2=buffer
        for i in range(n):
            temp=temp.next
        while temp.next:
            temp=temp.next
            temp2=temp2.next
        temp2.next=temp2.next.next
        return buffer.next
