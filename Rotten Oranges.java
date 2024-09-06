//Day 42 of #CrackYourInternship
public int orangesRotting(int[][] grid)
    {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i, j});
                }
            }
        }
        int mini = -1;
        int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()){
            mini++;
            int size = queue.size();
            for(int i = 0;i < size;i++){
                int row = queue.peek()[0];
                int col = queue.peek()[1];
                queue.poll();
                for(int j = 0;j < 4;j++){
                    int newi = row + dir[j][0];
                    int newj = col + dir[j][1];
                    if(newi >= 0 && newj >= 0 && newi < m && newj < n && grid[newi][newj] == 1){
                        grid[newi][newj] = 2;
                        queue.offer(new int[] {newi, newj});
                    }
                }
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return mini == -1 ? 0 : mini;
    }
