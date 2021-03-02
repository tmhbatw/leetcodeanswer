package forOffer;

import datastructure.TreeNode;

public class forOffer07 {
    /*Description
    * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
    * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    * */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }

    private TreeNode buildTree(int[] preorder,int[] inorder,int start1,int end1,int start2,int end2){
        if(end1<start1)
            return null;
        if(end1==start1)
            return new TreeNode(preorder[start1]);
        TreeNode res=new TreeNode(preorder[start1]);
        int index=start2;
        for(;index<=end2;index++){
            if(inorder[index]==preorder[start1])
                break;
        }
        res.left=buildTree(preorder,inorder,start1+1,index-start2+start1,start2,index-1);
        res.right=buildTree(preorder,inorder,index+1-end2+end1,end1,index+1,end2);
        return res;
    }
}
