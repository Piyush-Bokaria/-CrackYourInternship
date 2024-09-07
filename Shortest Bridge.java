//Day 43 of #CrackYourInternship
class Solution {
    int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    List<int[]> first;
    List<int[]> second;
    boolean f = false;
    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1){
            return;
        }
        grid[i][j] = 2;
        if(!f){
            first.add(new int[] {i, j});
        }
        else{
            second.add(new int[] {i, j});
        }
        for(int k = 0;k < 4;k++){
            dfs(grid, i + dir[k][0], j + dir[k][1]);
        }
    }
    public int shortestBridge(int[][] grid) {
        first = new ArrayList<>();
        second = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    f = true;
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int[] p1 : first) {
            for (int[] p2 : second) {
                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]) - 1;
                minDistance = Math.min(minDistance, dist);
            }
        }

        return minDistance;
    }
}
