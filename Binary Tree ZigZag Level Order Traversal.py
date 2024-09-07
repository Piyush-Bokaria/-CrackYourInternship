'''Day 43 of #CrackYourInternship'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        final=[]
        queue=[root]
        count=1
        while queue:
            count += 1
            temp = []
            for i in range(len(queue)):
                node = queue.pop(0)
                temp.append(node.val)
                if node.left :
                    queue.append(node.left)
                if node.right :
                    queue.append(node.right)
            if count % 2 != 0:
                final.append(temp[::-1])
            else :
                final.append(temp)
        return final
