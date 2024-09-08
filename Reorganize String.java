//Day 44 of #CrackYourInternship
import java.util.AbstractMap;
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(freq.entrySet());

        StringBuilder ans = new StringBuilder();
        while (heap.size() > 1) {
            Map.Entry<Character, Integer> a = heap.poll();
            Map.Entry<Character, Integer> b = heap.poll();

            ans.append(a.getKey());
            if (a.getValue() > 1) {
                heap.add(new AbstractMap.SimpleEntry<>(a.getKey(), a.getValue() - 1));
            }
            ans.append(b.getKey());
            if (b.getValue() > 1) {
                heap.add(new AbstractMap.SimpleEntry<>(b.getKey(), b.getValue() - 1));
            }
        }

        if (!heap.isEmpty()) {
            Map.Entry<Character, Integer> last = heap.poll();
            if (last.getValue() > 1) {
                return "";
            } else {
                ans.append(last.getKey());
            }
        }

        return ans.toString();
    }
}
