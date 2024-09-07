'''Day 43 of #CrackYourInternship'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.node=root

    def next(self) -> int:
        value=0
        if self.node.left:
            temp=self.node
            if temp.left.left:
                while temp.left.left:
                    temp=temp.left
                value=temp.left.val
                if temp.left.right:
                    temp.left=temp.left.right
                else:
                    temp.left=None
            elif temp.left.right:
                value=temp.left.val
                temp.left=temp.left.right
            else:
                value=temp.left.val
                temp.left=None
        elif self.node.right:
            temp=self.node.right
            value=self.node.val
            self.node=self.node.right
        else:
            value=self.node.val
            self.node.val=-1
        return value
    def hasNext(self) -> bool:
        if self.node and self.node.val!=-1:
            return True
        return False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
