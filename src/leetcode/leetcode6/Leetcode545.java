package leetcode.leetcode6;

import apple.laf.JRSUIUtils;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        result.add(root.val);

        if(root.left==null&&root.right==null)
            return result;

        if(root.left!=null){
            TreeNode left=root.left;
            result.add(left.val);
            while(left.left!=null||left.right!=null){
                left=left.left==null?left.right:left.left;
                result.add(left.val);
            }
        }
        if(result.size()>1)
            result.remove(result.size()-1);


        dfs(result,root);

        if(root.right!=null){
            result.remove(result.size()-1);
            int size=result.size();
            TreeNode r=root.right;
            result.add(size,r.val);
            while(r.right!=null||r.left!=null){
                r=r.right==null?r.left:r.right;
                result.add(size,r.val);
            }
        }
        return result;

    }

    private void dfs(List<Integer> result,TreeNode root){
        if(root.left==null&&root.right==null){
            result.add(root.val);
            return;
        }
        if(root.left!=null)
            dfs(result,root.left);
        if(root.right!=null)
            dfs(result,root.right);
    }
}
