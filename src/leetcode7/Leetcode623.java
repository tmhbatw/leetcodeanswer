package leetcode7;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode623 {
    /*Description
    * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
    * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
    * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
    * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
    * */

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode node=new TreeNode(v);
            node.left=root;
            return node;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        d--;
        while(--d>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        for(TreeNode cur:q){
            TreeNode left=cur.left;
            cur.left=new TreeNode(v);
            cur.left.left=left;
            TreeNode right=cur.right;
            cur.right=new TreeNode(v);
            cur.right.right=right;
        }
        return root;
    }
}
