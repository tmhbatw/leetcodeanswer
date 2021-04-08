package leetcode.leetcode6;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode530 {
    /*Description
    * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     * */


    List<Integer> list=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            result=Math.min(result,list.get(i)-list.get(i-1));
        }
        return result;
    }

    private void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }
}
