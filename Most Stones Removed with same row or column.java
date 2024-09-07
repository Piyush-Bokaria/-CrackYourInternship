//Day 43 of #CrackYourInternship
class Solution {
    private void dfs(int[][] stones, int index, boolean[] visited){
        visited[index] = true;
        for(int i = 0;i < stones.length;i++){
            if(!visited[i] && (stones[index][0] == stones[i][0] || stones[index][1] == stones[i][1])){
                dfs(stones, i, visited);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int result = 0;
        int n = stones.length;
        boolean[] visited = new boolean[n];
        for(int i = 0;i < n;i++){
            if(visited[i]){
                continue;
            }
            dfs(stones, i, visited);
            result++;
        }
        return n - result;
    }
}
