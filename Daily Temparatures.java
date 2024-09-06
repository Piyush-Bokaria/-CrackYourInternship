//Day 42 of #CrackYourInternship
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        stack.push(0);
        for(int i = 0;i < n;i++){
            int ind = i;
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                ind = stack.pop();
                result[ind] = i - ind;
            }
            stack.push(i);
        }
        return result;
    }
}
