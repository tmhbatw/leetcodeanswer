package leetcode.leetcode9;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Leetcode814 {
    public TreeNode pruneTree(TreeNode root) {
        return removeLeafNodes(root,0);
    }

    Map<TreeNode,TreeNode> father=new HashMap<>();
    Map<TreeNode,Boolean> isLeft=new HashMap<>();
    Queue<TreeNode> q=new LinkedList<>();
    int target;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode result=new TreeNode(target-1);
        result.left=root;
        this.target=target;

        dfs(result);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            TreeNode father=this.father.get(cur);
            if(isLeft.get(cur))
                father.left=null;
            else
                father.right=null;
            if(father.val==target&&father.left==null&&father.right==null)
                q.add(father);
        }
        return result.left;
    }

    private void dfs(TreeNode root){
        if(root.left!=null){
            father.put(root.left,root);
            isLeft.put(root.left,true);
            dfs(root.left);
        }
        if(root.right!=null){
            father.put(root.right,root);
            isLeft.put(root.right,false);
            dfs(root.right);
        }
        if(root.val==target&&root.left==null&&root.right==null){
            q.add(root);
        }
    }
}
