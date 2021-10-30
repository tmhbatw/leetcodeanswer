package leetcode.leetcode14;

import datastructure.TreeNode;

public class Leetcode1315 {

    int result=0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)
            return 0;
        boolean flag=root.val%2==0;
        dfs(root.left,flag);
        dfs(root.right,flag);
        return result;
    }

    private void dfs(TreeNode cur,boolean fatherIsEven){
        if(cur==null)
            return;
        if(fatherIsEven){
            if(cur.left!=null)
                result+=cur.left.val;
            if(cur.right!=null)
                result+=cur.right.val;
        }
        boolean flag=cur.val%2==0;
        dfs(cur.left,flag);
        dfs(cur.right,flag);
    }
}
