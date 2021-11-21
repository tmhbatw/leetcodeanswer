package leetcode.leetcode14;

import datastructure.ListNode;
import datastructure.TreeNode;

public class Leetcode1367 {

    boolean result=false;
    public boolean isSubPath(ListNode head, TreeNode root) {
        dfs(head,root);
        if(head!=null) {
            isSubPath(head,root.left);
            isSubPath(head,root.right);
        }
        return result;
    }

    private void dfs(ListNode head,TreeNode root){
        if(result)
            return;
        if(head==null){
            result=true;
            return;
        }
        if(root==null||head.val!=root.val){
            return;
        }

        dfs(head.next,root.left);
        dfs(head.next,root.right);
    }
}
