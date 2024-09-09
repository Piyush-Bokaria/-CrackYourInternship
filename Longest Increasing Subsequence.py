'''Day 45 of #CrackYourInternship'''
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        res = [nums[0]]

        for num in nums[1:] :  
            list_index = bisect_left(res, num)
            if list_index == len(res) :
                res.append(num)
            else :
                res[list_index] = num

        return len(res)
