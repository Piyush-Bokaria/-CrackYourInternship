//Day 43 of #CrackYourInternship
class Solution {
    int maxi = 0;
    private void dfs(List<Integer>[] graph, int headID, int[] time, int curr){
        maxi = Math.max(maxi, curr);

        for(int nex : graph[headID]){
            dfs(graph, nex, time, curr + time[headID]);
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i < n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i < manager.length;i++){
            int emp = i;
            int man = manager[i];
            if(man != -1){
                graph[man].add(emp);
            }
        }
        dfs(graph, headID, informTime, 0);
        return maxi;
    }
}
