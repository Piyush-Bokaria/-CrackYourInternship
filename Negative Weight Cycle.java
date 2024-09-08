//Day 44 of #CrackYourInternship
class Solution
{
    private int bfs(ArrayList<ArrayList<int[]>> adj, int n, int node){
        Queue<Integer> queue = new LinkedList<>();
        
        int[] cycle = new int[n];
        int[] path = new int[n];
        
        Arrays.fill(path, Integer.MAX_VALUE);
        
        queue.add(node);
        path[node] = 0;
        
        while(!queue.isEmpty()){
            int val = queue.poll();
            
            for(int[] adjn : adj.get(val)){
                if(path[val] + adjn[1] < path[adjn[0]]){
                    path[adjn[0]] = path[val] + adjn[1];
                    queue.offer(adjn[0]);
                    cycle[adjn[0]]++;
                    if(cycle[val] > n){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int m = edges.length;
        if(m <= 1){
            return 0;
        }
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            adj.get(u).add(new int[] {v, wt});
        }
        
        for(int i = 0;i < n;i++){
            if(bfs(adj, n, i) == 1){
                return 1;
            }
        }
        return 0;
    }
}
