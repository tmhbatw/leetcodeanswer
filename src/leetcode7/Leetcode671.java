package leetcode7;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode671 {
    /*Description
    * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
    * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
    * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
    * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1
    * */

    int val;
    int result;
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return -1;
        val=root.val;
        result=-1;
        find(root);
        return result;
    }

    private void find(TreeNode cur){
        if(cur==null)
            return;
        if(cur.val>val){
            result=result==-1?cur.val:Math.min(result,cur.val);
        }
        find(cur.left);
        find(cur.right);
    }
}
