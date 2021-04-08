package leetcode.leetcode2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode145 {
    /*Description
    * 给定一个二叉树，返回它的 后序 遍历。
     * */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        getNumber(root,result);
        return result;
    }

    private void getNumber(TreeNode node,List<Integer> result){
        if(node!=null){
            getNumber(node.left,result);
            getNumber(node.right,result);
            result.add(node.val);
        }
    }
}
