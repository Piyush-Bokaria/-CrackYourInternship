'''Day 45 of #CrackYourInternship'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) < 1:
            return 0
        
        row = len(matrix)
        col = len(matrix[0])
        
        dp = [[0]*(col+1) for _ in range(row+1)]
        maxi = 0
        
        for r in range(row):
            for c in range(col):
                if matrix[r][c] == '1':
                    dp[r+1][c+1] = min(dp[r][c], dp[r+1][c], dp[r][c+1]) + 1 
                    maxi = max(maxi, dp[r+1][c+1])
                
        return maxi * maxi
                
