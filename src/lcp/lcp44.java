package lcp;

import datastructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class lcp44 {

    Set<Integer> set=new HashSet<>();
    public int numColor(TreeNode root) {
        inOrder(root);
        return set.size();
    }

    private void inOrder(TreeNode root){
        if(root==null)
            return;
        set.add(root.val);
        inOrder(root.left);
        inOrder(root.right);
    }
}
