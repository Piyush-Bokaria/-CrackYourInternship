//Day 45 of #CrackYourInternship
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == n){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        result.reverse();
        while(result.length() > 1 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
