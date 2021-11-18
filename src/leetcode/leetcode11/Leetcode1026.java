package leetcode.leetcode11;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1026 {

    class Node{
        TreeNode root;
        int min;
        int max;
        public Node(TreeNode root,int min,int max){
            this.root=root;
            this.min=min;
            this.max=max;
        }
    }


    public int maxAncestorDiff(TreeNode root) {
        int result=0;
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(root,root.val,root.val));
        while(!q.isEmpty()){
            Node cur=q.poll();
            result=Math.max(result,Math.max(cur.root.val-cur.min,
                    cur.max-cur.root.val));
            if(cur.root.left!=null) {
                int val=cur.root.left.val;
                q.add(new Node(cur.root.left, Math.min(cur.min, val),Math.max(cur.max,val)));
            }
            if(cur.root.right!=null){
                int val=cur.root.right.val;
                q.add(new Node(cur.root.right,Math.min(cur.min,val),Math.max(cur.max,val)));
            }
        }
        return result;
    }
}
