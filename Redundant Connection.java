//Day 44 of #CrackYourInternship
class Solution {
    // Helper class to implement Union-Find
    class UnionFind {
        private int[] parent;
        private int[] rank;

        // Constructor to initialize the parent and rank arrays
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // each node is its own parent (itself)
                rank[i] = 1;   // each node has an initial rank of 1
            }
        }

        // Find operation with path compression
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // path compression
            }
            return parent[node];
        }

        // Union operation with rank optimization
        public boolean union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            
            if (root1 == root2) {
                // They are already connected, so adding this edge forms a cycle
                return false;
            }

            // Union by rank: attach the smaller tree under the larger one
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }

            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; // Number of edges (which is n+1 in total)
        UnionFind uf = new UnionFind(n + 1); // Union-Find for nodes from 1 to n

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If the union fails (they're already connected), return the current edge
            if (!uf.union(u, v)) {
                return edge;
            }
        }

        // This line should never be reached as the problem guarantees a solution
        return new int[0];
    }
}
