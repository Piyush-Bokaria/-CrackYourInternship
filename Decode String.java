//Day 43 of #CrackYourInternship
class Solution {
    public String decodeString(String s) {
        int n = s.length();
        String res = "";
        String temp = "";
        int ind = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<String> stackr = new Stack<>();
        for(int i = 0;i < n;i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                ind = ind * 10 + (s.charAt(i) - '0');
            }
            else if(s.charAt(i) == '['){
                stackr.push(res);
                stack.push(ind);
                ind = 0;
                res = "";
            }
            else if(s.charAt(i) == ']'){
                temp = res;
                for(int j = 1;j < stack.peek();j++){
                    res = res + temp;
                }
                stack.pop();
                res = stackr.peek() + res;
                stackr.pop();
            }
            else{
                res += s.charAt(i);
            }
        }
        return res;
    }
}
