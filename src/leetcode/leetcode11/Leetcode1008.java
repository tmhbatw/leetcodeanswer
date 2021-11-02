package leetcode.leetcode11;

import datastructure.TreeNode;

public class Leetcode1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length-1);
    }

    private TreeNode bstFromPreorder(int[] preorder,int i,int j){
        if(j<i)
            return null;
        if(j==i){
            return new TreeNode(preorder[i]);
        }

        int start=preorder[i];
        TreeNode root=new TreeNode(start);
        int nextJ=i+1;
        for(;nextJ<=j;nextJ++){
            if(preorder[nextJ]>start)
                break;
        }
        root.left=bstFromPreorder(preorder,i+1,nextJ-1);
        root.right=bstFromPreorder(preorder,nextJ,j);
        return root;
    }
}
