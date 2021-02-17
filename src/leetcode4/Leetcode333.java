package leetcode4;

import datastructure.TreeNode;

public class Leetcode333 {
    /*Description
    * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
    * 二叉搜索树（BST）中的所有节点都具备以下属性：
    * 左子树的值小于其父（根）节点的值。
    * 右子树的值大于其父（根）节点的值。注意:
    * 子树必须包含其所有后代
    * 进阶:
    * 你能想出 O(n) 时间复杂度的解法吗？
    * */

    int result=0;
    public int largestBSTSubtree(TreeNode root) {
        if(root==null)
            return result;
        recursion(root);
        return result;
    }

    private int[] recursion(TreeNode cur){
        int[] leftTime=new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        int[] rightTime=new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        if(cur.left!=null)
            leftTime=recursion(cur.left);
        if(cur.right!=null)
            rightTime=recursion(cur.right);
        int curVal=cur.val;
        if(leftTime[2]<0||rightTime[2]<0)
            return new int[]{0,0,-1};
        if(leftTime[2]>0&&curVal<=leftTime[1]||rightTime[2]>0&&curVal>=rightTime[0])
            return new int[]{0,0,-1};
        if(leftTime[2]==0&&rightTime[2]==0) {
            result=Math.max(1,result);
            return new int[]{curVal, curVal, 1};
        }
        if(leftTime[2]==0) {
            result=Math.max(rightTime[2]+1,result);
            return new int[]{curVal, rightTime[1], rightTime[2] + 1};
        }
        if(rightTime[2]==0) {
            result=Math.max(1+leftTime[2],result);
            return new int[]{leftTime[0], curVal, leftTime[2] + 1};
        }
        result=Math.max(result,rightTime[2]+leftTime[2]+1);
        return new int[]{leftTime[0],rightTime[1],rightTime[2]+leftTime[2]+1};
    }
}
