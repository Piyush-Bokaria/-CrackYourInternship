//Day 44 of #CrackYourInternship
class Solution {
    private boolean check(int start, int v, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int num : adj.get(curr)) {
                if (color[num] == -1) {
                    color[num] = 1 - color[curr];  // Assign opposite color
                    queue.offer(num);
                } else if (color[num] == color[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[v];
        Arrays.fill(color, -1);

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (!check(i, v, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
