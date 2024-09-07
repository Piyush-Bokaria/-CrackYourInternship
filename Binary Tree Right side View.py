'''Day 43 of #CrackYourInternship'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return

        final=[]

        queue=[]

        queue.append(root)

        while queue:
            for i in range(len(queue)):
                node=queue.pop(0)

                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)

            final.append(node.val)

        return final
