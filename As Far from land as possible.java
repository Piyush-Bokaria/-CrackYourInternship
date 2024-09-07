//Day 43 of #CrackYourInternship
class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int[][] visited = new int[n][n];  // No need to have separate m; since it's n x n
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        // Add all land cells to the queue and mark them as visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j, 0});
                    visited[i][j] = 1;
                }
            }
        }

        // If no land or all land, return -1
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int maxi = 0;

        // BFS from all land cells
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int dist = curr[2];
            maxi = Math.max(dist, maxi);

            for (int k = 0; k < 4; k++) {
                int newi = i + dir[k][0];
                int newj = j + dir[k][1];

                if (newi >= 0 && newi < n && newj >= 0 && newj < n && visited[newi][newj] == 0) {
                    visited[newi][newj] = 1;
                    queue.offer(new int[] {newi, newj, dist + 1});
                }
            }
        }

        return maxi;
    }
}
