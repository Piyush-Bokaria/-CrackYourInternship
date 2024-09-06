'''Day 42 of #CrackYourInternship'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for x in lists :
            node = x
            while node:
                heappush(heap, node.val)
                node = node.next
        res = ListNode(0)
        temp = res
        while heap :
            temp.next = ListNode(heappop(heap))
            temp = temp.next
        return res.next
