//Day 44 of #CrackYourInternship
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> dist = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hash.put(i, Integer.MAX_VALUE);  
            dist.put(i, new HashMap<>());
        }

        hash.put(src, 0);  

        for (int[] flight : flights) {
            dist.get(flight[0]).put(flight[1], flight[2]);  
        }

        for (int step = 0; step <= k; step++) {
            Map<Integer, Integer> temp = new HashMap<>(hash);  

            for (int i = 0; i < n; i++) {
                for (int next : dist.get(i).keySet()) {
                    if (hash.get(i) != Integer.MAX_VALUE) {
                        temp.put(next, Math.min(temp.get(next), hash.get(i) + dist.get(i).get(next)));
                    }
                }
            }
            hash = temp; 
        }

        return hash.get(dst) == Integer.MAX_VALUE ? -1 : hash.get(dst); 
    }
}
