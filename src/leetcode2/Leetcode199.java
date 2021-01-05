package leetcode2;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode199 {
    /*Description
    * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    * */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Deque<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            result.add(q.peekLast().val);
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.pollFirst();
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque.peekFirst());
    }
}
