//Day 45 of #CrackYourInternship
class Solution 
{ 
    int sameChar(String A, String B) 
    {
        // code here
        int result = 0;
        int n = A.length();
        for(int i = 0;i < n;i++){
            if(A.charAt(i) == B.charAt(i) || A.charAt(i) == B.charAt(i) + 32 || A.charAt(i) + 32 == B.charAt(i)){
                result++;
            }
        }
        return result;
    }
} 
