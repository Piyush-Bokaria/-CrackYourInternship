//Day 45 of #CrackYourInternship

class Solution
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        //code here.
        String[] result = {""};
        
        findcombi(str, k, 0, result);
        
        return result[0];
    }
    private static void findcombi(String str, int k, int index, String[] result){
        if(k == 0 || index == str.length() - 1){
            if(str.compareTo(result[0]) > 0){
                result[0] = str;
            }
            return;
        }
        for(int i = index + 1;i < str.length();i++){
            if(str.charAt(index) < str.charAt(i)){
                str = swap(index, i, str);
                findcombi(str, k - 1, index + 1, result);
                str = swap(index, i, str);
            }
        }
        findcombi(str, k, index + 1, result);
    }
    private static String swap(int index, int ind, String s){
        char[] ch = s.toCharArray();
        char c = ch[index];
        ch[index] = ch[ind];
        ch[ind] = c;
        return new String(ch);
    }
}
