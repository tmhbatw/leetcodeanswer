package leetcode.leetcode9;

import apple.laf.JRSUIUtils;
import datastructure.TreeNode;

import java.util.*;

public class Leetcode863 {

    List<Integer> result=new ArrayList<>();
    Map<TreeNode,TreeNode> father=new  HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null)
            return result;
        getFather(root);
        dfs(target,null,k);
        while(--k>=0&&father.containsKey(target)){
            dfs(father.get(target),target,k);
            target=father.get(target);
        }
        return result;
    }

    private void dfs(TreeNode cur,TreeNode exclude,int k){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(cur);
        while(k-->0){
            int size=q.size();
            while(size-->0){
                TreeNode node=q.poll();
                if(node.left!=null&&node.left!=exclude){
                    q.add(node.left);
                }
                if(node.right!=null&&node.right!=exclude){
                    q.add(node.right);
                }
            }
        }
        for(TreeNode node:q){
            result.add(node.val);
        }
    }

    private void getFather(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null){
                father.put(cur.left,cur);
                q.add(cur.left);
            }
            if(cur.right!=null){
                father.put(cur.right,cur);
                q.add(cur.right);
            }
        }
    }
}
