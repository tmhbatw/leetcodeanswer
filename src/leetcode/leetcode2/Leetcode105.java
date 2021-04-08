package leetcode.leetcode2;

import datastructure.TreeNode;

public class Leetcode105 {
    /*Description
    * 根据一棵树的前序遍历与中序遍历构造二叉树。
    * */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder,int start1,int end1,int[] inorder,int start2,int end2){
        if(start1>end1)
            return null;
        if(start1==end1)
            return new TreeNode(preorder[start1]);
        int curVal=preorder[start1];
        TreeNode curNode=new TreeNode(curVal);
        int index=start2;
        while(inorder[index]!=curVal)
            index++;
        int leftNumber=index-start2-1;
        int rightNumber=end2-index-1;
        curNode.left=buildTree(preorder,start1+1,
                leftNumber+1+start1,inorder,start2,index-1);
        curNode.right=buildTree(preorder,end1-rightNumber,end1,inorder,index+1,end2);
        return curNode;
    }
}
