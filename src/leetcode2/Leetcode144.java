package leetcode2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode144 {
    /*Description
    * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        getNumber(root,result);
        return result;
    }

    private void getNumber(TreeNode root,List<Integer> res){
        if(root!=null){
            res.add(root.val);
            getNumber(root.left,res);
            getNumber(root.right,res);
        }
    }
}
