package interview;

import datastructure.TreeNode;

import java.util.*;

public class Problem4_9 {
    /*Description
    * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
    * 给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
     * */

    List<List<Integer>> list;
    Deque<TreeNode> dq=new ArrayDeque<>();
    public List<List<Integer>> BSTSequences(TreeNode root) {
        list=new ArrayList<>();
        if(root==null) {
            list.add(new ArrayList<>());
            return list;
        }

        dq.add(root);
        dfs(new ArrayList<>());
        return list;
    }

    private void dfs(List<Integer> res){
        if(dq.isEmpty()){
            list.add(res);
            return;
        }
        int size=dq.size();
        for(int i=0;i<size;i++){
            List<Integer> cur=new ArrayList<>(res);
            TreeNode curr=dq.pollFirst();
            cur.add(curr.val);
            if(curr.left!=null)
                dq.add(curr.left);
            if(curr.right!=null)
                dq.add(curr.right);
            dfs(cur);
            if(curr.right!=null)
                dq.pollLast();
            if(curr.left!=null)
                dq.pollLast();
            dq.add(curr);
        }
    }
}
