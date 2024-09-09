//Day 45 of #CrackYourInternship
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int res = 0;
        for(char c = 'A'; c <= 'Z';c++){
            int i = 0;
            int j = 0;
            int count = 0;
            while(j < n){
                if(s.charAt(j) != c){
                    count++;
                }
                while(count > k){
                    res = Math.max(res, j - i);
                    if(s.charAt(i) != c){
                        count--;
                    }
                    i++;
                }
                j++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
