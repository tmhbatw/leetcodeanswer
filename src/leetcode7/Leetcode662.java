package leetcode7;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode662 {
    /*Description
    * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
    * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
    * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
    * */

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        q1.add(root);
        q2.add(0);
        int result=1;
        while(!q1.isEmpty()){
            int size=q1.size();
            int left=0,right=0;
            for(int i=0;i<size;i++){
                TreeNode cur=q1.poll();
                int pos=q2.poll();
                if(i==0)
                    left=pos;
                if(i==size-1)
                    right=pos;
                if(cur.left!=null){
                    q1.add(cur.left);
                    q2.add(pos*2);
                }
                if(cur.right!=null){
                    q1.add(cur.right);
                    q2.add(pos*2+1);
                }
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}
