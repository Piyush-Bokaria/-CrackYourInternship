//Day 43 of #CrackYourInternship


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        int[] count = new int[1]; 
        count[0] = 0;
        if(root == null){
            return 0;
        }
        findLargest(root, count);
        return count[0];   
    }
    static void findLargest(Node root, int[] count){
        if(root == null){
            return;
        }
        if(isBst(root, Integer.MAX_VALUE, Integer.MIN_VALUE)){
            int size = getsize(root);
            if(size > count[0]){
                count[0] = size;
            }
        }
        findLargest(root.left, count);
        findLargest(root.right, count);
    }
    static boolean isBst(Node root, int maxi, int mini){
        if(root == null){
            return true;
        }
        if(root.data <= mini || root.data >= maxi){
            return false;
        }
        return isBst(root.left, root.data, mini) && isBst(root.right, maxi, root.data);
    }
    static int getsize(Node root){
        if(root == null){
            return 0;
        }
        return 1 + getsize(root.left) + getsize(root.right);
    }
    
}
