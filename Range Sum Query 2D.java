//Day 45 of #CrackYourInternship
class NumMatrix {
    private int[][] prefixsum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefixsum = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                int left = (j > 0) ? prefixsum[i][j - 1] : 0;
                int above = (i > 0) ? prefixsum[i - 1][j] : 0;
                int aboveleft = (i > 0 && j > 0) ? prefixsum[i - 1][j - 1] : 0;
                prefixsum[i][j] = matrix[i][j] + left + above - aboveleft;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefixsum[row2][col2];
        int above = (row1 > 0) ? prefixsum[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? prefixsum[row2][col1 - 1] : 0;
        int aboveleft = (row1 > 0 && col1 > 0) ? prefixsum[row1 - 1][col1 - 1] : 0;
        return total - above - left + aboveleft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
