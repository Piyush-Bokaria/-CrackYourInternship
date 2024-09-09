'''Day 45 of #CrackYourInternship'''
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k == 0:
            return []
        result, curr = [], []
        def backtrack(curr, length):
            if length == k:
                result.append(curr)
                return
            if length == 0 :
                for i in range(n):
                    backtrack(curr + [i+1], length + 1)
            else:
                for i in range(curr[-1]+1, n +1):
                    backtrack(curr + [i], length + 1)

        backtrack(curr, 0)
        return result       
