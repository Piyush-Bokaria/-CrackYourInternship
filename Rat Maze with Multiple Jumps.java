//Day 45 of #CrackYourInternship
class Solution
{
    private boolean findShortestPath(int[][] mat, int sr, int sc, int[][] dir, int[][] result){
        int m = mat.length, n = mat[0].length;
        
        if(sr == m  - 1 && sc == n - 1){
            result[sr][sc] = 1;
            return true;
        }
        
        if(mat[sr][sc] == 0) return false;
        
        result[sr][sc] = 1;
        
        for(int rad = 1; rad <= mat[sr][sc]; rad++){
            
            for(int[] d: dir){
                int r = sr + rad * d[0];
                int c = sc + rad * d[1];
                
                if(r >= 0 && r <= m - 1 && c >= 0 && c <= n - 1){
                    boolean recAns = findShortestPath(mat, r, c, dir, result);
                    if(recAns) return true;
                }
            }
        }
        result[sr][sc] = 0;
        return false;
    }
    public int[][] ShortestDistance(int[][] matrix)
    {
        //Code here
        int m = matrix.length;
        int[][] result = new int[m][m];
        int[][] dir = {{0, 1}, {1, 0}};
        boolean res = findShortestPath(matrix, 0, 0, dir, result);
        if(!res) return new int[][]{{-1}};
        return result;
    }
}
