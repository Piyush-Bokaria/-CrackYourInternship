'''Day 42 of #CrackYourInternship'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head :
            return None
        return self.mergeSort(head)

    def mergeSort(self, head):
        if not head.next :
            return head
        slow = head
        fast = head
        while fast.next and fast.next.next :
            slow = slow.next
            fast = fast.next.next
        head2 = slow.next
        slow.next = None
        left = self.mergeSort(head)
        right = self.mergeSort(head2)
        return self.merge(left, right)

    def merge(self, temp1, temp2) :
        if not temp1 and not temp2 :
            return None
        if not temp1 :
            return temp2
        if not temp2 :
            return temp1
        temp = None
        if temp1.val < temp2.val:
            temp = temp1
            temp1 = temp1.next
        else :
            temp = temp2
            temp2 = temp2.next
        buffer = temp
        while temp1 and temp2:
            if temp1.val < temp2.val :
                temp.next = temp1
                temp1 = temp1.next
            else :
                temp.next = temp2
                temp2 = temp2.next
            temp = temp.next
        if temp1 :
            temp.next = temp1
        if temp2 :
            temp.next = temp2
        return buffer
