//Day 44 of #CrackYourInternship
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int num : nums){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(hash.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        int[] result = new int[k];
        for(int i = 0;i < k;i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}
