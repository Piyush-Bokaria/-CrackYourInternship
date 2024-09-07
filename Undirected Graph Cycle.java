//Day 43 of #CrackYourInternship

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V]; 

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {  
                if (detectCycleDFS(i, -1, visited, adj)) {  
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleDFS(int current, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[current] = true;  
        
        for (Integer neighbor : adj.get(current)) {
            if (!visited[neighbor]) {  
                if (detectCycleDFS(neighbor, current, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

}
