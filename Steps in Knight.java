//Day 43 of #CrackYourInternship
class Coordinates {
    int x;
    int y;
    int dist;

    Coordinates(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n) {
        boolean[][] visited = new boolean[n + 1][n + 1];
        int[][] dir = new int[][] {{-2, -1}, {-1, -2}, {1, 2}, {2, 1}, {2, -1}, {-1, 2}, {-2, 1}, {1, -2}};
        Queue<Coordinates> queue = new LinkedList<>();
        queue.offer(new Coordinates(KnightPos[0], KnightPos[1], 0));

        visited[KnightPos[0]][KnightPos[1]] = true;

        while (!queue.isEmpty()) {
            Coordinates curr = queue.poll();

            if (curr.x == TargetPos[0] && curr.y == TargetPos[1]) {
                return curr.dist;
            }

            for (int i = 0; i < 8; i++) {
                int x = curr.x + dir[i][0];
                int y = curr.y + dir[i][1];

                if (isValid(x, y, n) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new Coordinates(x, y, curr.dist + 1));
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, int n) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
}
