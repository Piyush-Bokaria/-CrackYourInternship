//Day 43 of #CrackYourInternship
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] arr = new ArrayList[n];

        for(int i = 0;i < n;i++){
            arr[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < graph[i].length;j++){
                arr[graph[i][j]].add(i);
                degree[i]++;
            }
        }
        int[] safe = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < n;i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            safe[curr] = 1;
            for(int a : arr[curr]){
                degree[a]--;
                if(degree[a] == 0){
                    queue.offer(a);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(safe[i] == 1){
                result.add(i);
            }
        }
        return result;
    }
}
