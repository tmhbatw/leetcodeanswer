package forOffer2;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ForOffer51 {

    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return result;
        getMaxValue(root);
        return result;
    }

    private int getMaxValue(TreeNode root){
        if(root==null)
            return 0;
        int leftValue=getMaxValue(root.left),rightValue=getMaxValue(root.right);
        result=Math.max(rightValue+leftValue+root.val,result);
        return Math.max(Math.max(leftValue,rightValue)+root.val,0);
    }


}
