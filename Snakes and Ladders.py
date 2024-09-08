'''Day 44 of #CrackYourInternship'''
class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        length = len(board)
        board.reverse()

        def inttopos(square):
            r = (square - 1)//length
            c = (square - 1) % length
            if r % 2:
                c = length - 1 - c
            return [r,c]

        queue = deque()
        queue.append([1, 0])
        visited = set()
        while queue:
            square, moves = queue.popleft()
            for i in range(1,7):
                nextsquare = square + i
                r, c = inttopos(nextsquare)
                if board[r][c] != -1:
                    nextsquare = board[r][c]
                if nextsquare == length*length:
                    return moves + 1
                if nextsquare not in visited:
                    visited.add(nextsquare)
                    queue.append([nextsquare, moves+1])
        return -1
