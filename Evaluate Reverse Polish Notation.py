'''Day 42 of #CrackYourInternship'''
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            try:
                num = int(token)
                stack.append(num)
            except ValueError:
                nums2 = stack.pop()
                nums1 = stack.pop()
                if token == '+':
                    stack.append(nums1 + nums2)
                elif token == '-':
                    stack.append(nums1 - nums2)
                elif token == '*':
                    stack.append(nums1 * nums2)
                else:
                    stack.append(int(nums1 / nums2))
        return stack.pop()
