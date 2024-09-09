//Day 45 of #CrackYourInternship
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        Set<Integer> st = new HashSet<>();
        int res = 0;
        Arrays.sort(freq);
        for(int ele : freq){
            if(ele == 0){
                continue;
            }
            if (!st.contains(ele)) {
                st.add(ele);
            } else {
                while (st.contains(ele)) {
                    ele--;
                    res++; 
                }
                if (ele != 0) {
                    st.add(ele);
                }
            }
        }
        return res;
    }
}
