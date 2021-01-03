package leetcode1;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode95 {
    /*Description
    * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     * */

    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return Collections.emptyList();
        return recursion(1,n);
    }

    private List<TreeNode> recursion(int start,int end){
        List<TreeNode> result=new ArrayList<>();
        if(start>end){
            result.add(null);
        }else if(start==end){
            result.add(new TreeNode(start));
        }else{
            for(int i=start;i<=end;i++){
                List<TreeNode> leftList=recursion(start,i-1);
                List<TreeNode> rightList=recursion(i+1,end);
                for(TreeNode left:leftList){
                    for(TreeNode right:rightList){
                        TreeNode cur=new TreeNode(i);
                        cur.left=left;
                        cur.right=right;
                        result.add(cur);
                    }
                }
            }
        }
        return result;
    }
}
