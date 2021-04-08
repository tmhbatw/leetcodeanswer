package leetcode.leetcode3;

import datastructure.TreeNode;

public class Leetcode222 {
    /*Description
    * 给出一个完全二叉树，求出该树的节点个数。
    * 说明：
    * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
    * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
    * */

    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }

/*    public int countNodes(TreeNode root) {
        int result=0;
        if(root==null)
            return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            result++;
            TreeNode cur=q.poll();
            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
        return result;
    }*/
}
