//Day 43 of #CrackYourInternship
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1; 
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] connection : connections) {
            int root1 = find(parent, connection[0]);
            int root2 = find(parent, connection[1]);

            if (root1 != root2) {
                union(parent, rank, root1, root2);
                components--; 
            }
        }

        return components - 1;
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // Path compression
        }
        return parent[node];
    }

    private void union(int[] parent, int[] rank, int root1, int root2) {
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }
}
