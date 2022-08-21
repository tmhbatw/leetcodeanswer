package leetcode.leetcode16;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1530 {

    int result=0;
    public int countPairs(TreeNode root, int distance) {
        getRes(root,distance);
        return result;
    }

    private List<Integer> getRes(TreeNode root,int distance){
        List<Integer> l=new ArrayList<>();
        if(root.left==null&&root.right==null){
            l.add(1);
            return l;
        }

        List<Integer> left=new ArrayList<>();
        if(root.left!=null){
            left=getRes(root.left,distance);
        }
        List<Integer> right=new ArrayList<>();
        if(root.right!=null)
            right=getRes(root.right,distance);

        for(int i:left){
            for(int j:right){
                if(i+j<=distance)
                    result++;
            }
            l.add(i+1);
        }

        for(int i:right)
            l.add(i+1);
        return l;
    }
}
