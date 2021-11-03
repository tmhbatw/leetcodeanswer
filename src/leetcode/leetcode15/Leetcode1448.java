package leetcode.leetcode15;

import datastructure.TreeNode;

import java.util.Stack;

public class Leetcode1448 {

//    public int goodNodes(TreeNode root) {
//        if(root==null)
//            return 0;
//        Stack<TreeNode> s1=new Stack<>();
//        Stack<Integer> s2=new Stack<>();
//        s1.add(root);
//        s2.add(root.val);
//        int result=0;
//        while(!s1.isEmpty()){
//            TreeNode cur=s1.pop();
//            int val=s2.pop();
//            if(cur.val>=val){
//                result++;
//                val=cur.val;
//            }
//            if(cur.left!=null){
//                s1.add(cur.left);
//                s2.add(val);
//            }
//            if(cur.right!=null){
//                s1.add(cur.right);
//                s2.add(val);
//            }
//        }
//        return result;
//    }
        int result=0;
        public int goodNodes(TreeNode root) {
            dfs(root,Integer.MIN_VALUE);
            return result;
        }

        private void dfs(TreeNode root,int val){
            if(root==null)
                return ;
            if(root.val>=val)
                result++;
            val=Math.max(val,root.val);
            dfs(root.left,val);
            dfs(root.right,val);
        }
}
