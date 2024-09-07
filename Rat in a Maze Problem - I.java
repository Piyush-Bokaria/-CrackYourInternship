//Day 43 of #CrackYourInternship

class Solution {
    ArrayList<String> result = new ArrayList<String>();

    public void dfs(String curr, int[][] mat, int n, int[] rc){
        if(rc[0] < 0 || rc[1] < 0 || rc[0] > n || rc[1] > n || mat[rc[0]][rc[1]] == 0){
            return;
        }

        if(rc[0] == n && rc[1] == n){
            result.add(curr);
            return;
        }
        mat[rc[0]][rc[1]] = 0;
        dfs(curr + "U", mat, n, new int[] {rc[0] - 1, rc[1]});
        dfs(curr + "L", mat, n, new int[] {rc[0], rc[1] - 1});
        dfs(curr + "D", mat, n, new int[] {rc[0] + 1, rc[1]});
        dfs(curr + "R", mat, n, new int[] {rc[0], rc[1] + 1});
        mat[rc[0]][rc[1]] = 1;
    }

    public ArrayList<String> findPath(int[][] mat) {
        result.clear();
        int n = mat.length - 1;
        if(mat[n][n] == 0 || mat[0][0] == 0){
            return result;
        }
        dfs("", mat, n, new int[] {0, 0});
        if(result.isEmpty()){
            result.add("-1");
        }
        return result;
    }
}
