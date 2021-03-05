package interview;

import datastructure.TreeNode;

public class Problem4_12 {
    /*Description
    * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，
    * 打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，
    * 但是其方向必须向下(只能从父节点指向子节点方向)。
    * */

    int result=0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        if(root.val==sum){
            result++;
        }
        if(root.left!=null){
            dfs(root.val,root.left,sum);
            pathSum(root.left,sum);
        }
        if(root.right!=null){
            dfs(root.val,root.right,sum);
            pathSum(root.right,sum);
        }
        return result;
    }

    private void dfs(int curVal,TreeNode cur,int sum){
        curVal+=cur.val;
        if(curVal==sum)
            result++;
        if(cur.left!=null){
            dfs(curVal,cur.left,sum);
        }
        if(cur.right!=null){
            dfs(curVal,cur.right,sum);
        }
    }
}
