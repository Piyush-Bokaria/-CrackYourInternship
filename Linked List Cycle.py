'''Day 45 of #CrackYourInternship'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return False
        temp=head
        while temp:
            if temp.val==('inf'):
                return True
            temp.val=('inf')
            temp=temp.next
        return False
