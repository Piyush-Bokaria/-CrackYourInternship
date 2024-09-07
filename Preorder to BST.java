//Day 43 of #CrackYourInternship
static class Solution {
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        Node root = null;
        for(int val : pre){
            Node curr = new Node(val);
            if(root == null){
                root = curr;
            }
            else{
                Node temp = root;
                while(true){
                    if(val < temp.data){
                        if(temp.left == null){
                            temp.left = curr;
                            break;
                        }
                        temp = temp.left;
                    }
                    else if(val > temp.data){
                        if(temp.right == null){
                            temp.right = curr;
                            break;
                        }
                        temp = temp.right;
                    }
                    else{
                        continue;
                    }
                }
            }
        }
        return root;
    }
}
