'''Day 45 of #CrackYourInternship'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def bst(nums) :
            if not nums :
                return 
            index = len(nums) // 2
            node = TreeNode(nums[index])
            node.left = bst(nums[:index])
            node.right = bst(nums[index + 1:])
            return node
        return bst(nums)
