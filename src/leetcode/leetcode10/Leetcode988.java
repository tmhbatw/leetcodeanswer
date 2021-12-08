package leetcode.leetcode10;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Leetcode988 {

    Map<TreeNode,TreeNode> father=new HashMap<>();
    Queue<TreeNode> q=new LinkedList<>();
    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        String result="";
        for(TreeNode node:q){
            StringBuilder sb=new StringBuilder();
            getRes(node,sb);
            if(result.length()==0||result.compareTo(sb.toString())>0){
                result=sb.toString();
            }
        }
        return result;
    }

    private void getRes(TreeNode node,StringBuilder sb){
        sb.append((char)(node.val+'a'));
        if(father.containsKey(node))
            getRes(father.get(node),sb);
    }


    private void dfs(TreeNode cur){
        if(cur.left==null&&cur.right==null){
            q.add(cur);
        }

        if(cur.left!=null){
            father.put(cur.left,cur);
            dfs(cur.left);
        }
        if(cur.right!=null){
            father.put(cur.right,cur);
            dfs(cur.right);
        }
    }
}
