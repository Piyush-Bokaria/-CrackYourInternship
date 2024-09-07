'''Day 43 of #CrackYourInternship'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def inorder(node, arr):
            if not root :
                return
            if node.left :
                inorder(node.left, arr)
            arr.append(node.val)
            if node.right :
                inorder(node.right, arr)
            if node == root :
                return arr[k - 1]
            return arr
        return inorder(root, [])
