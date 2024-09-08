//Day 44 of #CrackYourInternship
class Solution {
    int[][] dir = new int[][]{{1, 0}, {0, 1}};
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        pq.add(new int[] {0, 0, matrix[0][0]});
        
        for(int j = 0; j < k; j++) {
            int[] node = pq.poll();
            int x = node[0];
            int y = node[1];
            int val = node[2];
            
            if (j == k - 1) {
                return val;
            }
            
            for(int[] d : dir) {
                int newx = x + d[0];
                int newy = y + d[1];
                if(newx >= 0 && newy >= 0 && newx < n && newy < n && !visited[newx][newy]) {
                    visited[newx][newy] = true;
                    pq.add(new int[] {newx, newy, matrix[newx][newy]});
                }
            }
        }
        return -1;
    }
}
