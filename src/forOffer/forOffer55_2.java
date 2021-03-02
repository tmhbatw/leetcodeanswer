package forOffer;

import datastructure.TreeNode;

public class forOffer55_2 {
    int depth=0;
    boolean isBalanced=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return isBalanced;
    }

    private int getDepth(TreeNode root){
        if(!isBalanced||root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        if(Math.abs(left-right)>1){
            isBalanced=false;
            return 0;
        }
        return Math.max(left,right)+1;
    }
}
