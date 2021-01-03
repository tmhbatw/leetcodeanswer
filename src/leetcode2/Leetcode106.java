package leetcode2;

import datastructure.TreeNode;

public class Leetcode106 {
    /*Description
    * 根据一棵树的中序遍历与后序遍历构造二叉树。
    * */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int start1,int end1,int[] postorder,int start2,int end2){
        if(start2>end2)
            return null;
        if(start2==end2)
            return new TreeNode(postorder[start2]);
        int curVal=postorder[end2];
        TreeNode curNode=new TreeNode(curVal);
        int index=start1;
        while(inorder[index]!=curVal)
            index++;
        int leftNumber=index-start1-1;
        curNode.left=buildTree(inorder,start1,index-1,postorder,start2,start2+leftNumber);
        int rightNumber=end1-index-1;
        curNode.right=buildTree(inorder,index+1,end1,postorder,end2-1-rightNumber,end2-1);
        return curNode;
    }
}
