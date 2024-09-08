'''Day 44 of #CrackYourInternship'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        step, value = 0, 1 << amount
        
        while value & 1 != 1:
            temp = value

            for num in coins :
                temp |= value >> num

            if bin(temp) == bin(2**amount + 1) :
                return step + 1
            
            if temp == value :
                return -1
            
            step, value = step + 1, temp
        
        return step
