//Day 43 of #CrackYourInternship
class Solution
{
    //Function to return list containing vertices in Topological order. 
    
    static void dfs(int start, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        visited[start] = true;
        
        for(int neigh : adj.get(start)){
            if(!visited[neigh]){
                dfs(neigh, visited, stack, adj);
            }
        }
        stack.push(start);
    }
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < v;i++){
            if(!visited[i]){
                dfs(i, visited, stack, adj);
            }
        }
        int[] result = new int[v];
        for(int i = 0;i < v;i++){
            result[i] = stack.peek();
            stack.pop();
        }
        return result;
    }
}
