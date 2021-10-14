package leetcode.leetcode10;

import datastructure.TreeNode;

public class Leetcode993 {

    TreeNode father1=new TreeNode();
    int height1=0;

    TreeNode father2=new TreeNode();
    int height2=0;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null||root.val==x||root.val==y)
            return false;
        findNode(root,x,0,true);
        findNode(root,y,0,false);

        return father1.val!=father2.val&&height1==height2;
    }

    private void findNode(TreeNode root,int x,int curLevel,boolean isFirst){
        if(root.left!=null&&root.left.val==x||root.right!=null&&root.right.val==x){
            if(isFirst){
                height1=curLevel;
                father1=root;
            }else{
                height2=curLevel;
                father2=root;
            }
        }
        if(root.left!=null)
            findNode(root.left,x,curLevel+1,isFirst);
        if(root.right!=null)
            findNode(root.right,x,curLevel+1,isFirst);
    }
}
