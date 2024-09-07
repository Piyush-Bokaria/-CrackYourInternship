//Day 43 of #CrackYourInternship
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        ArrayList<ArrayList<Integer>> transposedGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transposedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                transposedGraph.get(neighbor).add(i);
            }
        }

        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                reverseDfs(v, transposedGraph, visited);
                sccCount++;
            }
        }
        return sccCount;
    }
    
    
    private void dfs(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, stack);
            }
        }

        stack.push(v);
    }

    private void reverseDfs(int v, ArrayList<ArrayList<Integer>> transposedGraph, boolean[] visited) {
        visited[v] = true;

        for (int neighbor : transposedGraph.get(v)) {
            if (!visited[neighbor]) {
                reverseDfs(neighbor, transposedGraph, visited);
            }
        }
    }
}

