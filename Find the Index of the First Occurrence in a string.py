'''Day 45 of #CrackYourInternship'''
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n=len(needle)
        for i in range(0,len(haystack)):
            if haystack[i:i+n]==needle:
                return i
        else:
            return -1
