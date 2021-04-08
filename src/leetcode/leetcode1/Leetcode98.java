package leetcode.leetcode1;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode98 {
    /*Description
    * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    * 假设一个二叉搜索树具有如下特征：
    * 节点的左子树只包含小于当前节点的数。
    * 节点的右子树只包含大于当前节点的数。
    * 所有左子树和右子树自身必须也是二叉搜索树。
    * */

    public boolean isValidBST(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        preface(result,root);
        for(int i=1;i<result.size();i++){
            if(result.get(i)<=result.get(i-1))
                return false;
        }
        return true;
    }


    private void preface(List<Integer> res,TreeNode root){
        if(root!=null){
            preface(res,root.left);
            res.add(root.val);
            preface(res,root.right);
        }
    }
}
