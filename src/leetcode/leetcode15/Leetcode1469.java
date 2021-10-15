package leetcode.leetcode15;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1469 {

    List<Integer> result;
    public List<Integer> getLonelyNodes(TreeNode root) {
        result=new ArrayList<>();
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root){
        if(root==null)
            return ;
        if(root.left==null&&root.right!=null)
            result.add(root.right.val);
        if(root.right==null&&root.left!=null)
            result.add(root.left.val);
        inOrder(root.left);
        inOrder(root.right);
    }
}
