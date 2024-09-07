//Day 43 of #CrackYourInternship
class Solution{
    private int i = 0;
    private Node helper(int[] pre, char[] preLN){
        Node curr = new Node(pre[i]);
	    if(preLN[i] == 'N'){
	        i++;
	        curr.left = helper(pre, preLN);
	        i++;
	        curr.right = helper(pre, preLN);
	    }
	    return curr;
    }
    Node constructTree(int n, int pre[], char preLN[]){
	    // code here
	    return helper(pre, preLN);
    }
}
