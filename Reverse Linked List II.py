'''Day 42 of #CrackYourInternship'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left==right:
            return head
        temp1=head
        temp2=head
        count=1
        reversehead=ListNode()
        te=reversehead
        while count!=right:
            if count<left:
                t=ListNode(temp1.val)
                te.next=t
                te=te.next
                temp1=temp1.next
            temp2=temp2.next
            count+=1
        rightend=temp2.next
        t=ListNode(temp2.val)
        te.next=t
        te=te.next
        while temp1!=temp2:
            temp=temp1
            while temp.next!=temp2:
                temp=temp.next
            t=ListNode(temp.val)
            te.next=t
            te=te.next
            temp2=temp
        while rightend:
            t=ListNode(rightend.val)
            te.next=t
            te=te.next
            rightend=rightend.next
        return reversehead.next
