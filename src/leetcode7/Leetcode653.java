package leetcode7;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode653 {
    /*Description
    *给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
    * */

    List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list=new ArrayList<>();
        if(root!=null)
            inOrder(root);
        int left=0,right=list.size()-1;
        while(left<right){
            int cur=list.get(left)+list.get(right);
            if(cur==k)
                return true;
            if(cur<k)
                left++;
            else
                right--;
        }
        return false;
    }

    private void inOrder(TreeNode root){
        if(root.left!=null)
            inOrder(root.left);
        list.add(root.val);
        if(root.right!=null)
            inOrder(root.right);
    }
}
