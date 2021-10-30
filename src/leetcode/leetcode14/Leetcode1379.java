package leetcode.leetcode14;

import datastructure.TreeNode;

public class Leetcode1379 {


    TreeNode result=null;
    public final TreeNode getTargetCopy(final TreeNode original,
                                        final TreeNode cloned, final TreeNode target) {

        dfs(cloned,target);
        return result;
    }

    private void dfs(TreeNode cloned,TreeNode target){
        if(result!=null||cloned==null)
            return ;
        if(cloned.val==target.val){
            result=cloned;
            return;
        }
        dfs(cloned.left,target);
        dfs(cloned.right,target);
    }
}
