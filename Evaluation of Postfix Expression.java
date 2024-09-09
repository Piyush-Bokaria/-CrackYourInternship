//Day 45 of #CrackYourInternship

class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(c >= '0' && c <= '9'){
                stack.push(c - '0');
            }
            else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(c == '+'){
                    stack.push(num2 + num1);
                }
                else if(c == '-'){
                    stack.push(num1 - num2);
                }
                else if(c == '*'){
                    stack.push(num1 * num2);
                }
                else{
                    stack.push(num1 / num2);
                }
            }
        }
        return stack.pop();
    }
}
