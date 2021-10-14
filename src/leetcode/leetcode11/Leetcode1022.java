package leetcode.leetcode11;

import datastructure.TreeNode;

public class Leetcode1022 {
    int result=0;
    public int sumRootToLeaf(TreeNode root) {
        inOrder(root,0);
        return result;
    }

    private void inOrder(TreeNode cur,int pre){
        if(cur==null)
            return;
        pre=pre*2+cur.val;
        if(cur.left==null&&cur.right==null){
            result+=pre;
            return;
        }
        inOrder(cur.left,pre);
        inOrder(cur.right,pre);
    }
}
