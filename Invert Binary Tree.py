//Day 45 of #CrackYourInternship
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue = [root]
        while queue :
            for i in range(len(queue)) :
                node = queue.pop(0)
                if node and node.left and node.right:
                    node.left, node.right = node.right, node.left
                    queue.append(node.left)
                    queue.append(node.right)
                elif node and not node.right :
                    node.right = node.left
                    node.left = None
                    queue.append(node.right)
                elif node and not node.left :
                    node.left = node.right
                    node.right = None
                    queue.append(node.left)
                else :
                    continue
        return root
