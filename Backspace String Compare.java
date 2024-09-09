//Day 45 of #CrackYourInternship
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '#'){
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }
            else{
                s1.push(s.charAt(i));
            }
        }
        for(char c : t.toCharArray()){
            if(c == '#' && !s2.isEmpty()){
                s2.pop();
            }
            else if(c != '#'){
                s2.push(c);
            }
        }
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.pop() != s2.pop()){
                return false;
            }
        }
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        return false;
    }
}
