package leetcode.leetcode9;

import datastructure.TreeNode;

public class Leetcode889 {


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return getRes(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode getRes(int[] pre,int s1,int e1,int[] post,int s2,int e2){
        System.out.println();
        if(e1<s1)
            return null;
        if(e1==s1)
            return new TreeNode(pre[s1]);
        TreeNode root=new TreeNode(pre[s1]);
        int index=s2;
        for(;index<=e2;index++){
            if(post[index]==pre[s1+1])
                break;
        }

        root.left=getRes(pre,s1+1,index-s2+s1+1,post,s2,index);
        root.right=getRes(pre,e1-e2+index+2,e1,post,index+1,e2-1);
        return root;
    }


}
