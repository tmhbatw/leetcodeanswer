package leetcode.leetcode14;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1382 {


    List<Integer> list=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        return getRes(0,list.size()-1);
    }

    private TreeNode getRes(int start,int end){
        if(end<start)
            return null;
        if(end==start)
            return new TreeNode(list.get(start));
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(list.get(mid));

        root.left=getRes(start,mid-1);
        root.right=getRes(mid+1,end);
        return root;
    }

    private void dfs(TreeNode root){
        if(root==null)
            return ;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

}
